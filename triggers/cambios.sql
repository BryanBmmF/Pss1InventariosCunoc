ALTER TABLE LOG_EVENTO
CHANGE COLUMN `tipo` `tipo` enum('I', 'U', 'D') NOT NULL ,
CHANGE COLUMN descripcion descripcion VARCHAR(200) NOT NULL;


ALTER TABLE `inventario`.`PROVEEDOR`
DROP INDEX `nit_UNIQUE` ,
DROP INDEX `nombreProveedor_UNIQUE` ;


#TRIGGERS 

#Trigger para insercion-------------------------------------------------------------------------------

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





#Estructura para comparar cadenas----------------------------------------------------------------------

    -- verificando cambios en descripcion
    IF ((OLD.descripcion LIKE New.descripcion))=0 THEN BEGIN
		SET cambios = CONCAT("(",OLD.descripcion,",",NEW.descripcion,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion descripcion de factura (v,n):",cambios));
    END;END IF;


#Estructura para comparar datos numericos-----------------------------------------------------------------

	-- verificando cambios en numero de factura
    IF ((OLD.numero_Factura != New.numero_Factura)) THEN BEGIN
		SET cambios = CONCAT("(",OLD.numero_Factura,",",NEW.numero_Factura,")");
		INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion Numero Factura(v,n):",cambios));
    END;END IF;


#Estructura para comparar datos de llaves foraneas

-- verificando cambios en Proveedor------------------------------------------------------------------------
 
 IF ((OLD.id_Proveedor != NEW.id_Proveedor)) THEN BEGIN
		DECLARE proveedorNuevo varchar(50);
        DECLARE proveedorViejo varchar(50);
        SET proveedorNuevo =(SELECT nombre_Proveedor FROM PROVEEDOR WHERE id_Proveedor=NEW.id_Proveedor);
        SET proveedorViejo =(SELECT nombre_Proveedor FROM PROVEEDOR WHERE id_Proveedor=OLD.id_Proveedor);
		SET cambios = CONCAT("(",proveedorViejo,",",proveedorNuevo,")");
        INSERT INTO LOG_EVENTO(fecha,tipo,id_log_ingreso,descripcion) VALUES
		(fecha,'U',idLogIngreso,CONCAT(fecha,".Actualizacion de Proveedor en factura(v,n):",cambios));
    END;END IF;
    
