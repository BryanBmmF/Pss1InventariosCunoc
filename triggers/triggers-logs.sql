
USE inventario;

#Creacion de procedimiento que devolvera el ID de el ultimo LOG_INGRESO
DROP FUNCTION IF EXISTS obtener_id_log_ingreso;

DELIMITER $$
CREATE FUNCTION obtener_id_log_ingreso() RETURNS INT
BEGIN
	 DECLARE idLog INT;
     SET idLog=(SELECT id FROM LOG_INGRESO GROUP BY id DESC LIMIT 1);
     RETURN idLog;
END $$
DELIMITER ;

#Creacion de TRIGGERS

/**--------------------Tabla PROVEEDOR-------------------------------------*/

#Insert
DROP TRIGGER  IF exists PROVEEDOR_AI;
DELIMITER $$

CREATE TRIGGER PROVEEDOR_AI AFTER INSERT ON PROVEEDOR

FOR EACH ROW 
BEGIN
	DECLARE idLogIngreso INT;
    DECLARE fecha TIMESTAMP;
    SET idLogIngreso =obtener_id_log_ingreso();
    SET fecha = now();
	INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
    (fecha,'I',idLogIngreso,CONCAT(fecha,".Se inserto el proveedor:",NEW.nombre_Proveedor));
END $$

DELIMITER ;

#UPDATE

DROP TRIGGER IF exists PROVEEDOR_AU;

DELIMITER $$

CREATE TRIGGER PROVEEDOR_AU AFTER UPDATE ON PROVEEDOR

FOR EACH ROW 
BEGIN
	DECLARE idLogIngreso INT;
    DECLARE fecha TIMESTAMP;
	DECLARE cambios VARCHAR(200);
    SET idLogIngreso =obtener_id_log_ingreso();
    SET fecha = now();
    -- verificando cambios en nombre
    IF ((OLD.nombre_Proveedor LIKE New.nombre_Proveedor))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.nombre_Proveedor,",",NEW.nombre_Proveedor,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Nombre Proveedor(v,n):",cambios));
    END;END IF;
    -- verificando cambios en nit
    IF ((OLD.nit LIKE New.nit))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.nit,",",NEW.nit,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion NIT Proveedor (v,n):",cambios));
    END;END IF;
    -- verificando cambios en direccion
    IF ((OLD.direccion LIKE New.direccion))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.direccion,",",NEW.direccion,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Direccion Proveedor(v,n):",cambios));
    END;END IF;
    -- verificando cambios en descripcion
    IF ((OLD.descripcion LIKE New.descripcion))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.descripcion,",",NEW.descripcion,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Descripcion Proveedor(v,n):",cambios));
    END;END IF;
	-- verificando cambios en correoElectronico
    IF ((OLD.correoElectronico LIKE New.correoElectronico))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.correoElectronico,",",NEW.correoElectronico,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Correo Proveedor(v,n):",cambios));
    END;END IF;

END $$

DELIMITER ;

/**************FACTURA******************/


#Insert
DROP TRIGGER  IF exists FACTURA_AI;
DELIMITER $$

CREATE TRIGGER FACTURA_AI AFTER INSERT ON FACTURA

FOR EACH ROW 
BEGIN
	DECLARE idLogIngreso INT;
    DECLARE fecha TIMESTAMP;
    SET idLogIngreso =obtener_id_log_ingreso();
    SET fecha = now();
	INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
    (fecha,'I',idLogIngreso,CONCAT(fecha,".Se inserto la factura con descripcion:",NEW.descripcion));
END $$

DELIMITER ;

#UPDATE

DROP TRIGGER IF exists FACTURA_AU;

DELIMITER $$

CREATE TRIGGER FACTURA_AU AFTER UPDATE ON FACTURA

FOR EACH ROW 
BEGIN
	DECLARE idLogIngreso INT;
    DECLARE fecha TIMESTAMP;
	DECLARE cambios VARCHAR(200);
    SET idLogIngreso =obtener_id_log_ingreso();
    SET fecha = now();

    -- verificando cambios en descripcion
    IF ((OLD.descripcion LIKE New.descripcion))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.descripcion,",",NEW.descripcion,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion descripcion de factura (v,n):",cambios));
    END;END IF;
    -- verificando cambios en VALOR
    IF ((OLD.valor != New.valor)) THEN BEGIN
		SET cambios = CONCAT("(",OLD.valor,",",NEW.valor,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Valor Factura(v,n):",cambios));
    END;END IF;
	-- verificando cambios en fecha
    IF ((OLD.fecha LIKE New.fecha))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.fecha,",",NEW.fecha,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion fecha Factura(v,n):",cambios));
    END;END IF;
	-- verificando cambios en numero de factura
    IF ((OLD.numero_Factura != New.numero_Factura)) THEN BEGIN
		SET cambios = CONCAT("(",OLD.numero_Factura,",",NEW.numero_Factura,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Numero Factura(v,n):",cambios));
    END;END IF;
    
-- verificando cambios en Proveedor
 
 IF ((OLD.id_Proveedor != NEW.id_Proveedor)) THEN BEGIN
		DECLARE proveedorNuevo varchar(50);
        DECLARE proveedorViejo varchar(50);
        SET proveedorNuevo =(SELECT nombre_Proveedor FROM PROVEEDOR WHERE id_Proveedor=NEW.id_Proveedor);
        SET proveedorViejo =(SELECT nombre_Proveedor FROM PROVEEDOR WHERE id_Proveedor=OLD.id_Proveedor);
		SET cambios = CONCAT("(",proveedorViejo,",",proveedorNuevo,")");
        INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion de Proveedor en factura(v,n):",cambios));
    END;END IF;
    
END $$

DELIMITER ;


/****************************BIEN***********************************/

#Insert
DROP TRIGGER  IF exists BIEN_AI;
DELIMITER $$

CREATE TRIGGER BIEN_AI AFTER INSERT ON BIEN

FOR EACH ROW 
BEGIN
	DECLARE idLogIngreso INT;
    DECLARE fecha TIMESTAMP;
    SET idLogIngreso =obtener_id_log_ingreso();
    SET fecha = now();
	INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
    (fecha,'I',idLogIngreso,CONCAT(fecha,".Insercion de bien:",NEW.cur," tipo:",NEW.tipo));
END $$

DELIMITER ;


#UPDATE
DROP TRIGGER IF EXISTS BIEN_AU;

DELIMITER $$
	
CREATE TRIGGER BIEN_AU AFTER UPDATE ON BIEN
FOR EACH ROW
BEGIN

	DECLARE idLogIngreso INT;
    DECLARE fecha TIMESTAMP;
	DECLARE cambios VARCHAR(200);
    SET idLogIngreso =obtener_id_log_ingreso();
    SET fecha = now();


	-- verificando cambios en CUR
    IF ((OLD.cur LIKE New.cur))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.cur,",",NEW.cur,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Cur Bien(v,n):",cambios));
    END;END IF;

		-- verificando cambios en Procedencia
    IF ((OLD.procedencia LIKE New.procedencia))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.procedencia,",",NEW.procedencia,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Procedencia Bien(v,n):",cambios));
    END;END IF;


	-- verificando cambios en Descripcion
    IF ((OLD.descripcion LIKE New.descripcion))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.descripcion,",",NEW.descripcion,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Descripcion Bien(v,n):",cambios));
    END;END IF;
    
	-- verificando cambios en Division
    IF ((OLD.division LIKE New.division))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.division,",",NEW.division,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Division Bien(v,n):",cambios));
    END;END IF;

	-- verificando cambios en id_Factura
 IF ((OLD.id_Factura != NEW.id_Factura)) THEN BEGIN
        INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion de Factura Bien:",NEW.cur));
    END;END IF;

	-- verificando cambios valor
    IF ((OLD.valor != New.valor)) THEN BEGIN
		SET cambios = CONCAT("(",OLD.valor,",",NEW.valor,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Valor en Bien(v,n):",cambios));
    END;END IF;

	-- verificando cambios en estado
    IF ((OLD.estado LIKE New.estado))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.estado,",",NEW.estado,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Cambio de estado en Bien(v,n):",cambios));
    END;END IF;


END $$

DELIMITER ;



/****************************INVENTARIO***********************************/

#Insert
DROP TRIGGER  IF exists INVENTARIO_AI;
DELIMITER $$

CREATE TRIGGER INVENTARIO_AI AFTER INSERT ON INVENTARIO

FOR EACH ROW 
BEGIN
	DECLARE idLogIngreso INT;
    DECLARE fecha TIMESTAMP;
    SET idLogIngreso =obtener_id_log_ingreso();
    SET fecha = now();
	INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
    (fecha,'I',idLogIngreso,CONCAT(fecha,".Creacion de un nuevo inventario:",NEW.descripcion));
END $$

DELIMITER ;


#UPDATE
DROP TRIGGER IF EXISTS INVENTARIO_AU;

DELIMITER $$
CREATE TRIGGER INVENTARIO_AU AFTER UPDATE ON INVENTARIO

FOR EACH ROW
BEGIN

	DECLARE idLogIngreso INT;
    DECLARE fecha TIMESTAMP;
	DECLARE cambios VARCHAR(200);
    SET idLogIngreso =obtener_id_log_ingreso();
    SET fecha = now();

	-- verificando cambios en fecha_inicio
    IF ((OLD.fecha_inicio LIKE New.fecha_inicio))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.fecha_inicio,",",NEW.fecha_inicio,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion fecha inicio Inventario (v,n):",cambios));
    END;END IF;


	-- verificando cambios en descripcion
    IF ((OLD.descripcion LIKE New.descripcion))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.descripcion,",",NEW.descripcion,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion descripcion Inventario (v,n):",cambios));
    END;END IF;

	-- verificando cambios en unidad_academica
    IF ((OLD.unidad_academica LIKE New.unidad_academica))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.unidad_academica,",",NEW.unidad_academica,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Unidad academica Inventario (v,n):",cambios));
    END;END IF;


	-- verificando cambios en fecha_finalizacion
    IF ((OLD.fecha_finalizacion LIKE New.fecha_finalizacion))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.fecha_finalizacion,",",NEW.fecha_finalizacion,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Fecha final Inventario (v,n):",cambios));
    END;END IF;

END $$    
DELIMITER ;


/****************************Tarjeta de responsabilidad***********************************/

#Insert
DROP TRIGGER  IF exists TARJETA_RESPONSABILIDAD_AI;
DELIMITER $$

CREATE TRIGGER TARJETA_RESPONSABILIDAD_AI AFTER INSERT ON TARJETA_RESPONSABILIDAD

FOR EACH ROW 
BEGIN
	DECLARE idLogIngreso INT;
    DECLARE fecha TIMESTAMP;
    SET idLogIngreso =obtener_id_log_ingreso();
    SET fecha = now();
	INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
    (fecha,'I',idLogIngreso,CONCAT(fecha,".Creacion de tarjeta de responsabilidad No.Serie:",NEW.no_serie));
END $$

DELIMITER ;


/****************************Encargado ***********************************/

#Insert
DROP TRIGGER  IF exists ENCARGADO_AI;
DELIMITER $$

CREATE TRIGGER ENCARGADO_AI AFTER INSERT ON ENCARGADO

FOR EACH ROW 
BEGIN
	DECLARE idLogIngreso INT;
    DECLARE fecha TIMESTAMP;
    SET idLogIngreso =obtener_id_log_ingreso();
    SET fecha = now();
	INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
    (fecha,'I',idLogIngreso,CONCAT(fecha,".Creacion de encargado:",NEW.nombre));
END $$

DELIMITER ;

DROP TRIGGER IF EXISTS ENCARGADO_AU;

DELIMITER $$

CREATE TRIGGER ENCARGADO_AU AFTER UPDATE ON ENCARGADO
FOR EACH ROW
BEGIN
	DECLARE idLogIngreso INT;
    DECLARE fecha TIMESTAMP;
	DECLARE cambios VARCHAR(200);
    SET idLogIngreso =obtener_id_log_ingreso();
    SET fecha = now();
    
        -- verificando cambios en nombre
    IF ((OLD.nombre LIKE New.nombre))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.nombre,",",NEW.nombre,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion nombre Encargado (v,n):",cambios));
    END;END IF;
    
	-- verificando cambios en apellido
    IF ((OLD.apellido LIKE New.apellido))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.apellido,",",NEW.apellido,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion apellido Encargado (v,n):",cambios));
    END;END IF;
    
	-- verificando cambios en cargo
    IF ((OLD.cargo LIKE New.cargo))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.cargo,",",NEW.cargo,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Cargo Encargado (v,n):",cambios));
    END;END IF;
    
	-- verificando cambios en division
    IF ((OLD.division LIKE New.division))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.division,",",NEW.division,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Division Encargado (v,n):",cambios));
    END;END IF;
    
END $$

DELIMITER ;
