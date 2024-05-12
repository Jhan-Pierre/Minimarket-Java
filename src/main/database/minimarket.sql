-- ##################################################################################################
-- Zona segura
-- ##################################################################################################
create database bd_minimarket;
-- drop database bd_minimarket;
use bd_minimarket;         

CREATE TABLE tb_estado(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL unique
);

create table tb_turno(
	id int not null auto_increment primary key,
    nombre varchar(80) not null unique
);

create table tb_rol(
	id int not null auto_increment primary key,
    nombre varchar(40) not null
);

create table tb_modulo(
	id bigint not null auto_increment primary key,
    nombre varchar(80) not null
);

create table tb_permiso(
	id bigint not null auto_increment primary key,
    nombre varchar(80) not null,
    modulo_id bigint,
    foreign key (modulo_id) references tb_modulo(id)
);

create table tb_rol_permiso(
	id bigint not null auto_increment primary key,
	rol_id int,
    permiso_id bigint,
    foreign key (rol_id) references tb_rol(id),
    foreign key (permiso_id) references tb_permiso(id)
);

create table tb_usuario(
	id bigint not null auto_increment primary key,
    correo varchar(60) not null unique,
    password varchar(200) not null,
    telefono char(9) not null unique,
    nombre varchar(80) not null,
    apellido varchar(80) not null,
    fecha_alta datetime,
    fecha_actualizado datetime,
    rol_id int not null,
    estado_id int not null,
    turno_id int,
    foreign key (rol_id) references tb_rol (id),
    foreign key (estado_id) references tb_estado (id),
    foreign key (turno_id) references tb_turno (id)
);

create table tb_proveedor(
	id int not null auto_increment primary key,
    nombre varchar(80) not null unique,
    ruc char(11) not null unique,
    descripcion varchar(250) not null,
    telefono char(9) not null unique,
    correo varchar(60) not null unique,
    direccion varchar(100) not null,
    estado_id int not null,
    foreign key (estado_id) REFERENCES tb_estado(id)
);

create table tb_categoria_producto(
	id int not null auto_increment primary key,
    nombre varchar(60) not null
);

create table tb_producto(
	id bigint not null auto_increment primary key,
    nombre varchar(100) not null unique,
    precio_compra decimal(10,2) not null,
    precio_venta decimal(10,2) not null,
    stock_disponible int not null,
    codigoBarras varchar(50) not null unique,
    categoria_producto_id int,
    estado_id int,
    foreign key (categoria_producto_id) references tb_categoria_producto (id),
    foreign key (estado_id) references tb_estado (id)
);

create table tb_pedido(
	id int not null auto_increment primary key, 
    fecha date not null,
    costoTotal decimal(10,2) not null,
    usuario_id bigint,
    proveedor_id int,
    foreign key (usuario_id) references tb_usuario (id),
	foreign key (proveedor_id) references tb_proveedor (id)
);

create table tb_detalle_pedido(
    cantidad int not null,
    precioUnitario double not null,
    pedido_id int,
    producto_id bigint,
    foreign key (pedido_id) references tb_pedido (id),
    foreign key (producto_id) references tb_producto (id)
);

create table tb_tipo_comprobante(
	id int not null auto_increment primary key, 
    comprobante varchar(50) not null
);

create table tb_metodo_pago(
	id int not null auto_increment primary key, 
    metodo_pago varchar(50) not null
);

create table tb_venta(
	id int not null auto_increment primary key, 
    fecha_hora datetime not null,
    impuesto decimal(10,2),
    total decimal(10,2) not null,
    tipo_comprobante_id int,
    metodo_pago_id int,
    usuario_id bigint,
    foreign key (tipo_comprobante_id) references tb_tipo_comprobante (id),
    foreign key (metodo_pago_id) references tb_metodo_pago (id),
    foreign key (usuario_id) references tb_usuario (id)
);

create table tb_detalle_venta(
	id int not null auto_increment primary key, 
    precio_unitario decimal(10,2) not null,
    subtotal decimal(10,2) not null,
    cantidad int,
    producto_id bigint,
    id_venta int,
    foreign key (producto_id) references tb_producto (id),
    foreign key (id_venta) references tb_venta (id)
);

create table tb_cesta_temporal(
	id int not null auto_increment primary key,
    precio_unitario decimal(10,2) not null,
    cantidad int not null,
    subtotal decimal(10,2) not null,
    usuario_id bigint not null,
    producto_id bigint not null,
    foreign key (usuario_id) references tb_usuario (id),
    foreign key (producto_id) references tb_producto (id)
);
-- *****************************************************************************************************************
-- Procedimientos alamcenados para cesta temporal
-- *****************************************************************************************************************
DELIMITER ;;
CREATE PROCEDURE sp_login(
    IN p_email VARCHAR(40),
    OUT p_hashed_password VARCHAR(191),
    OUT p_user_id BIGINT,
    OUT p_is_active BOOLEAN
)
BEGIN
    DECLARE v_user_id BIGINT;
    DECLARE v_is_active BOOLEAN;
    DECLARE v_hashed_password VARCHAR(191);
    
    -- Buscar el hash de la contraseña y el estado del usuario por correo electrónico
    SELECT id, password, estado_id INTO v_user_id, v_hashed_password, v_is_active
    FROM tb_usuario
    WHERE correo = p_email;
    
    -- Asignar los resultados a los parámetros de salida
    SET p_user_id = v_user_id;
    SET p_hashed_password = v_hashed_password;
    SET p_is_active = v_is_active = 1;
END ;; //

DELIMITER //
CREATE PROCEDURE sp_obtener_permisos_por_rol(
    IN v_rol_id VARCHAR(60)
)
BEGIN
    -- Verificar si se encontró un rol para el usuario
    IF v_rol_id IS NULL THEN
        SELECT 'El rol no existe' AS mensaje;
    ELSE
        -- Recuperar los nombres de los permisos asociados al rol
        SELECT p.nombre AS permiso
        FROM tb_permiso p
        INNER JOIN tb_rol_permiso rp ON p.id = rp.permiso_id
        WHERE rp.rol_id = v_rol_id;
    END IF;
END; //

-- call sp_obtener_permisos_por_rol(1)

delimiter //
create procedure sp_obtener_usuario_logeado(
	IN p_correo VARCHAR(60)
)
begin
	SELECT u.id, u.correo, concat(u.nombre, ' ', u.apellido) as nombre, u.rol_id
    FROM tb_usuario AS u
    WHERE u.correo = p_correo;
end; //
-- ##################################################################################################
-- Zona segura
-- ##################################################################################################
-- ##################################################################################################
-- Zona experimental
-- ##################################################################################################
delimiter //
create procedure sp_exite_codigo_barras(
	in p_codigo_barras varchar(50),
	out p_valido boolean
)
begin 
	declare contador int;
    
    -- Verificar si el código de barras existe en la tabla 'products'
    SELECT COUNT(*) INTO contador FROM tb_producto WHERE codigoBarras = p_codigo_barras;

    -- Si el contador es mayor que 0, el código de barras es válido
    IF contador > 0 THEN
        SET p_valido = TRUE;
    ELSE
        SET p_valido = FALSE;
    END IF;
end; //

DELIMITER //
CREATE PROCEDURE sp_registrar_cesta_temporal(
    IN p_usuario_id bigint,
    IN p_codigobarras VARCHAR(50)
)
BEGIN
    DECLARE v_producto_id INT;
    DECLARE v_producto_nombre VARCHAR(100);
    DECLARE v_producto_precio_venta decimal(10,2);
    DECLARE v_cantidad_existente INT;

    -- Obtener el ID del producto según el código de barras
    SELECT id, precio_venta INTO v_producto_id, v_producto_precio_venta
    FROM tb_producto
    WHERE codigoBarras = p_codigobarras;

    -- Verificar si el producto ya está en la cesta para el mismo usuario
    SELECT cantidad INTO v_cantidad_existente
    FROM tb_cesta_temporal
    WHERE usuario_id = p_usuario_id AND producto_id = v_producto_id;

    IF v_cantidad_existente IS NOT NULL THEN
        -- El producto ya existe, actualizar la cantidad y subtotal
        UPDATE tb_cesta_temporal
        SET cantidad = cantidad + 1,
            subtotal = (cantidad  * v_producto_precio_venta)
        WHERE usuario_id = p_usuario_id AND producto_id = v_producto_id;
    ELSE
        -- El producto no existe, insertarlo con cantidad 1
        INSERT INTO tb_cesta_temporal (precio_unitario, cantidad, subtotal, usuario_id, producto_id)
        VALUES (v_producto_precio_venta, 1, v_producto_precio_venta, p_usuario_id, v_producto_id);
    END IF;
END //

-- call sp_registrar_cesta_temporal(3, '9022345678901')

delimiter //
create procedure sp_editar_cesta_temporal_cantidad (
	in p_usuario_id int,
	in p_cantidad int,
    in p_nombre_producto varchar(100)
)
begin
	declare v_precio_unitario decimal(10,2);
    declare v_producto_id int;
    
	-- Obtener el ID del producto según el nombre
    select precio_venta, id into  v_precio_unitario, v_producto_id
    from tb_producto where nombre = p_nombre_producto;
 
    update tb_cesta_temporal set cantidad = p_cantidad,  subtotal = (p_cantidad * v_precio_unitario)
    where usuario_id = p_usuario_id AND producto_id = v_producto_id;
    
end; //

-- call sp_editar_cesta_temporal_cantidad(2, 2, "Atún enlatado")

delimiter //
create procedure sp_consultar_cesta_temporal_usuario(in p_idusuario int)
begin
	select p.nombre as producto,p.precio_venta as precio_unitario, ct.cantidad, ct.subtotal
    from tb_cesta_temporal ct
    inner join tb_producto p on ct.producto_id = p.id
    where ct.usuario_id = p_idusuario;
end //
-- call sp_consultar_cesta_temporal_usuario(3)
delimiter //
create procedure sp_eliminar_item_cesta_temporal(
	in p_usuario_id int,
    in p_nombre_producto varchar(100)
)
begin
	declare v_producto_id int;
    
    -- Obtener el ID del producto según el nombre
    select id into v_producto_id from tb_producto where nombre = p_nombre_producto;
    
    -- Eliminar item de la cesta temporal
    delete from tb_cesta_temporal where usuario_id = p_usuario_id and producto_id = v_producto_id;
    
end; //

delimiter //
create procedure sp_eliminar_cesta_temporal_usuario(in p_usuario_id int)
begin 
	delete from tb_cesta_temporal where usuario_id =  p_usuario_id;
end; //
-- call sp_eliminar_cesta_temporal_usuario("2");
-- CALL sp_eliminar_item_cesta_temporal(2, 'Papas Fritas');


-- *****************************************************************************************************************
-- Procedimientos alamcenados para Proveedor
-- *****************************************************************************************************************
delimiter //
create procedure sp_listar_proveedor()
begin
    select p.id, p.nombre, p.ruc, p.correo, e.nombre as estado
    from tb_proveedor p
    inner join tb_estado e ON p.estado_id = e.id;
end //

-- call sp_listar_proveedor();

delimiter //
create procedure sp_buscar_proveedor_por_codigo(in codproveedor int)
begin
	select p.id, p.nombre, p.ruc, p.descripcion,p.telefono, p.correo, p.direccion, e.nombre as estado
    from tb_proveedor p
    inner join tb_estado e on p.estado_id = e.id
    where p.id = codproveedor;
end; //
-- call sp_buscar_proveedor_por_codigo('12');

delimiter //
create procedure sp_registrar_proveedor(
    in nombre VARCHAR(100),
    in ruc VARCHAR(15),
    in descripcion VARCHAR(255),
    in telefono VARCHAR(20),
    in correo VARCHAR(100),
    in direccion VARCHAR(255),
    in estado_id INT
)
begin	
    insert into tb_proveedor (nombre, ruc, descripcion, telefono, correo, direccion, estado_id)
    values (nombre, ruc, descripcion, telefono, correo, direccion, estado_id);
end //


delimiter //
CREATE PROCEDURE sp_editar_proveedor(
    IN p_codprov INT,
    IN p_nombre VARCHAR(80),
    IN p_ruc CHAR(11),
    IN p_descripcion VARCHAR(250),
    IN p_telefono CHAR(9),
    IN p_correo VARCHAR(60),
    IN p_direccion VARCHAR(100),
    IN p_estado_proveedor_id INT
)
BEGIN
    UPDATE tb_proveedor
    SET nombre = p_nombre,
        ruc = p_ruc,
        descripcion = p_descripcion,
        telefono = p_telefono,
        correo = p_correo,
        direccion = p_direccion,
        estado_id = p_estado_proveedor_id
    WHERE id = p_codprov;
END //

-- call sp_editar_proveedor(1, 'DiestrituiUUdorade Alfa Enlatados', '22345678900', 'Proveedor de alimentos enlatados', '987954329', 'info@alfa.com', 'Calle Principal #888', 1);

-- select * from tb_proveedor;

delimiter //
create procedure sp_borrar_proveedor(
    IN p_idProveedor INT
)
begin
    delete from tb_proveedor WHERE id = p_idProveedor;
end //

-- call sp_listar_proveedor();
-- call sp_borrar_proveedor('18');

DELIMITER $$
CREATE PROCEDURE sp_consultar_proveedor_codigo(
    IN codprov INT
)
BEGIN
    SELECT * FROM tb_proveedor
    WHERE id = codprov;
END$$
DELIMITER ;

-- call sp_consultar_proveedor_codigo('2');

DELIMITER $$
CREATE PROCEDURE sp_filtrar_proveedor(
    IN valor VARCHAR(40)
)
BEGIN
    SELECT * FROM tb_proveedor
    WHERE nombre LIKE CONCAT('%', valor, '%');
END$$
DELIMITER ;
 -- call sp_filtrar_proveedor('Distribuidora')

delimiter //
create procedure sp_actualizar_estado_proveedor(in codprov int, in idesta int)
begin
	update tb_proveedor set estado_id = idesta
    where id = codprov;
end //

delimiter //
create procedure sp_listar_estado_proveedor()
begin
	select * from tb_estado;
end //



-- *****************************************************************************************************************
-- *****************************************************************************************************************
-- Procedimientos alamcenados para Productos

delimiter //
create procedure sp_listar_productos()
begin
    select p.id, 
        p.nombre, 
        p.precio_compra, 
        p.precio_venta, 
        p.stock_disponible, 
        p.codigoBarras, 
        c.nombre as categoria,
        e.nombre as estado,
        p.estado_id
    from tb_producto p
    left join  tb_categoria_producto c on p.categoria_producto_id = c.id
    left join tb_estado e on p.estado_id = e.id;
end; //

delimiter //
create procedure sp_buscar_producto_por_codigo(in codigobar varchar(50))
begin
    select nombre, precio_venta
    from tb_producto
    where codigoBarras = codigobar;
end; //

delimiter //
create procedure sp_mostrar_producto_por_codigo(
    in producto_id int
)
begin
    select 
        p.id, 
        p.nombre, 
        p.stock_disponible as stock, 
        p.precio_compra, 
        p.precio_venta,
        p.codigoBarras,
        c.nombre as categoria,
        e.nombre as estado
    from 
        tb_producto p
	inner join 
        tb_categoria_producto c on p.categoria_producto_id = c.id
    inner join 
        tb_estado e on p.estado_id = e.id
    where 
        p.id = producto_id;
end; //

-- CALL sp_mostrar_producto_por_codigo('1');

delimiter //
create procedure sp_filtrar_producto(
    in valor varchar(100)
)
begin
    select 
        p.id, 
        p.nombre, 
        p.stock_disponible as stock, 
        p.precio_compra, 
        p.precio_venta,
        p.codigobarras,
        c.nombre as categoria_producto, 
        e.nombre as estado_producto
    from 
        tb_producto p
    inner join
        tb_categoria_producto c on p.categoria_producto_id = c.id
    left join 
        tb_estado e on p.estado_id = e.id
    where 
        p.nombre like concat('%', valor, '%');
end; //

-- CALL sp_filtrar_producto('man');

delimiter //
create procedure sp_listar_categoria_producto()
begin
    select * from tb_categoria_producto;
end; //

DELIMITER //

CREATE PROCEDURE sp_buscar_categoria_por_nombre(
    IN nombre_categoria VARCHAR(60)
)
BEGIN
    SELECT * FROM tb_categoria_producto
    WHERE nombre LIKE CONCAT('%', nombre_categoria, '%');
END//


delimiter //
create procedure sp_registrar_producto(
    in p_nombre varchar(100),
    in p_precio_compra decimal(10,2),
    in p_precio_venta decimal(10,2),
    in p_stock_disponible int,
    in p_codigo_barras varchar(100),
    in p_categoria_producto_id int,
    in p_estado_id int
)
begin
    insert into tb_producto (nombre, precio_compra, precio_venta, stock_disponible, codigoBarras, categoria_producto_id, estado_id)
    values (p_nombre, p_precio_compra, p_precio_venta, p_stock_disponible, p_codigo_barras, p_categoria_producto_id, p_estado_id);
end; //


delimiter //
create procedure sp_editar_producto(
    in p_id int,
    in p_nombre varchar(255),
    in p_precio_compra decimal(10,2),
    in p_precio_venta decimal(10,2),
    in p_stock_disponible int,
    in p_codigo_barras varchar(255),
    in p_categoria_producto_id int,
    in p_estado_id int
)
begin
    update tb_producto
    set nombre = p_nombre,
        precio_compra = p_precio_compra,
        precio_venta = p_precio_venta,
        stock_disponible = p_stock_disponible,
        codigoBarras = p_codigo_barras,
        categoria_producto_id = p_categoria_producto_id,
        estado_id = p_estado_id
    where id = p_id;
end; //

delimiter //
create procedure sp_eliminar_producto(
    in p_id int
)
begin
    delete from tb_producto
    where id = p_id;
end; //

delimiter //
create procedure sp_listar_estado_producto()
begin
	select * from tb_estado;
end //

delimiter //

create procedure sp_buscar_producto_por_ID(IN codprod INT)
begin
    select * from tb_producto
    where id = codprod;
end;//

delimiter //
create procedure sp_actualizar_estado_producto(in codprod int, in idesta int)
begin
	update tb_producto set estado_id = idesta
    where id = codprod;
end //


-- call sp_buscar_producto_por_codigo("1234567890188")

-- call sp_listar_productos()

-- call sp_buscar_producto_por_codigo("1234567890188")

-- *****************************************************************************************************************
-- Procedimientos alamcenados para Ventas y sus detalles
-- *****************************************************************************************************************
delimiter //
create procedure sp_listar_tipo_comprobante()
begin
	select id, comprobante from tb_tipo_comprobante;
end //

delimiter //
create procedure sp_listar_metodo_pago()
begin
	select id, metodo_pago from tb_metodo_pago;
end //


delimiter //
create procedure sp_listar_venta()
begin
	select v.id, v.fecha_hora, v.impuesto, v.total, c.comprobante, mp.metodo_pago, concat(u.nombre, ' ', u.apellido) as usuario
    from tb_venta v
    inner join tb_tipo_comprobante c on v.tipo_comprobante_id = c.id
    inner join tb_metodo_pago mp on v.metodo_pago_id = mp.id
    inner join tb_usuario u on v.usuario_id = u.id;
end; //

delimiter //
CREATE PROCEDURE sp_buscar_venta_por_nombre_usuario(IN nombre VARCHAR(160))
BEGIN
    SELECT v.id, v.fecha_hora, v.impuesto, v.total, c.comprobante, mp.metodo_pago, CONCAT(u.nombre, ' ', u.apellido) AS usuario
    FROM tb_venta v
    INNER JOIN tb_tipo_comprobante c ON v.tipo_comprobante_id = c.id
    INNER JOIN tb_metodo_pago mp ON v.metodo_pago_id = mp.id
    INNER JOIN tb_usuario u ON v.usuario_id = u.id
    WHERE u.nombre LIKE CONCAT('%', nombre, '%'); -- Búsqueda aproximada por nombre
END; //

delimiter //
create procedure sp_buscar_venta_por_codigo(in codventa int)
begin
	select v.id, v.fecha_hora, v.impuesto, v.total, c.comprobante, mp.metodo_pago, concat(u.nombre, ' ', u.apellido) as usuario
    from tb_venta v
    inner join tb_tipo_comprobante c on v.tipo_comprobante_id = c.id
    inner join tb_metodo_pago mp on v.metodo_pago_id = mp.id
    inner join tb_usuario u on v.usuario_id = u.id
    where v.id = codventa;
end; //

-- call sp_buscar_venta_por_codigo("4");

delimiter //
create procedure sp_filtrar_venta_por_rango_fecha(
	in p_fecha_inicio date,
    in p_fecha_fin date
)	
begin
	set p_fecha_fin = date_add(p_fecha_fin, interval 1 day); -- incrementar un dia a la fecha fin, para que en el filtrado tenga en cuenta el mismo dia de fin

	select v.id, v.fecha_hora, v.impuesto, v.total, c.comprobante, mp.metodo_pago, concat(u.nombre, ' ', u.apellido) as usuario
    from tb_venta v
    inner join tb_tipo_comprobante c on v.tipo_comprobante_id = c.id
    inner join tb_metodo_pago mp on v.metodo_pago_id = mp.id
    inner join tb_usuario u on v.usuario_id = u.id
    where fecha_hora >= p_fecha_inicio and fecha_hora < p_fecha_fin;
end ; //

-- CALL sp_filtrar_venta_por_rango_fecha('2024-04-16', '2024-04-18');

delimiter //
create procedure sp_buscar_detalle_venta_por_codigo(in codventa int)
begin
	select p.nombre, dv.precio_unitario,
    dv.cantidad, dv.subtotal
    from tb_detalle_venta dv
    inner join tb_producto p on dv.producto_id = p.id
    where id_venta = codventa;
end; //

-- call sp_buscar_detalle_venta_por_codigo("4");

delimiter //
create procedure sp_registrar_venta(
	in p_impuesto decimal(10,2),
    in p_total decimal(10,2),
    in p_tipo_comprobante_id int,
    in p_metodo_pago_id int,
    in p_usuario_id int
)
begin
	declare v_venta_id int;

	-- Insertar los parámetros de entrada a la tabla venta
	insert into tb_venta (fecha_hora, impuesto, total, tipo_comprobante_id, metodo_pago_id, usuario_id)
    values (now(), p_impuesto, p_total, p_tipo_comprobante_id, p_metodo_pago_id, p_usuario_id);
    
    -- Obtener el ID de la venta recién insertada
    set v_venta_id = last_insert_id();
    
    -- Insertar los datos de la cesta temporal en la tabla tb_detalle_venta
    insert into tb_detalle_venta (precio_unitario, subtotal, cantidad, producto_id, id_venta)
    select precio_unitario, subtotal, cantidad, producto_id, v_venta_id
    from tb_cesta_temporal
    where usuario_id = p_usuario_id;
    
    -- Actualizar el stock disponible en la tabla tb_producto
    update tb_producto p
    join tb_cesta_temporal ct on p.id = ct.producto_id
    set p.stock_disponible = p.stock_disponible - ct.cantidad
    where ct.usuario_id = p_usuario_id;
    
    -- Limpiar la cesta temporal después de la venta
    DELETE FROM tb_cesta_temporal WHERE usuario_id = p_usuario_id;
    
end //
delimiter ;


delimiter //
create procedure sp_eliminar_venta(in p_id_venta int)
begin
	delete from tb_detalle_venta where id_venta = p_id_venta; -- eliminar los detalles de la venta
    
    delete from tb_venta where id = p_id_venta; -- eliminar la propia venta
end; //

-- call sp_eliminar_venta("3")

-- CALL sp_registrar_venta(18.5, 250.75, 1, 3, 2);
-- select * from tb_venta;
-- select * from tb_cesta_temporal
-- *****************************************************************************************************************

-- *****************************************************************************************************************
-- Procedimientos alamcenados para Uliente
-- *****************************************************************************************************************
delimiter //
create procedure sp_listar_usuario()
begin
	select u.id,
			u.correo,
            concat(u.nombre, ' ' , u.apellido) as nombre,
            u.telefono,
            u.fecha_alta,
            r.nombre as rol,
            e.nombre as estado
    from tb_usuario u
    inner join tb_rol r on u.rol_id = r.id
    inner join tb_estado e on u.estado_id = e.id
    order by u.fecha_actualizado;
end //
-- call sp_listar_usuario();

delimiter //
create procedure sp_buscar_usuario_por_nombre(
    in p_nombre varchar(80) -- Parámetro para el nombre a buscar
)
begin
    select u.id,
            u.correo,
            concat(u.nombre, ' ' , u.apellido) as nombre,
            u.telefono,
            u.fecha_alta,
            r.nombre as rol,
            e.nombre as estado
    from tb_usuario u
    inner join tb_rol r on u.rol_id = r.id
    inner join tb_estado e on u.estado_id = e.id
    where u.nombre like concat('%', p_nombre, '%')
    order by u.fecha_actualizado;
end; //


-- call sp_buscar_usuario_por_nombre("a")
DELIMITER //
CREATE PROCEDURE sp_crear_usuario(
    IN p_correo VARCHAR(60),
    IN p_password VARCHAR(200),
    IN p_telefono CHAR(9),
    IN p_nombre VARCHAR(80),
    IN p_apellido VARCHAR(80),
    IN p_rol_id INT,
    IN p_estado_id INT,
    IN p_turno_id INT
)
BEGIN
    DECLARE exit handler for sqlexception
    BEGIN
        -- Manejo de errores
        ROLLBACK;
        RESIGNAL;
    END;

    START TRANSACTION;

    -- Insertar el nuevo usuario
    INSERT INTO tb_usuario (correo, password, telefono, nombre, apellido, fecha_alta, fecha_actualizado, rol_id, estado_id, turno_id)
    VALUES (p_correo, p_password, p_telefono, p_nombre, p_apellido, NOW(), now(), p_rol_id, p_estado_id, p_turno_id);

    COMMIT;
END; //

delimiter //
create procedure sp_buscar_usuario_por_codigo(in iduser int)
begin
	select  correo,
           telefono,
           nombre,
           apellido,
           rol_id,
           turno_id,
           estado_id
    from tb_usuario
    where id = iduser;
end //

delimiter //
create procedure sp_listar_rol_usuario()
begin
	select id, nombre from tb_rol;
end //

delimiter //
create procedure sp_listar_turno_usuario()
begin
	select id, nombre from tb_turno;
end //

delimiter //
create procedure sp_listar_estado()
begin
	select id, nombre from tb_estado;
end //

DELIMITER //
CREATE PROCEDURE sp_mostrar_usuario_por_codigo(IN iduser INT)
BEGIN
    SELECT u.id,
           u.correo,
           u.telefono,
           u.nombre,
           IFNULL(u.apellido, '') AS apellido,
           fecha_alta,
           fecha_actualizado,
           r.nombre AS rol,
           IFNULL(tu.nombre, 'Sin turno') AS turno,
           e.nombre AS estado
    FROM tb_usuario u
    INNER JOIN tb_rol r ON u.rol_id = r.id
    LEFT JOIN tb_turno tu ON u.turno_id = tu.id
    INNER JOIN tb_estado e ON u.estado_id = e.id
    WHERE u.id = iduser;
END //



-- CALL sp_registrar_usuario('usuaradsio@example.com', 'contraseña123', '123451889', 'Juan', 'torres', 2, 1, 1);
-- select * from tb_usuario
DELIMITER //
CREATE PROCEDURE sp_editar_usuario(
    IN p_id BIGINT,
    IN p_correo VARCHAR(60),
    IN p_password VARCHAR(200),
    IN p_telefono CHAR(9),
    IN p_nombre VARCHAR(80),
    IN p_apellido VARCHAR(80),
    IN p_rol_id INT,
    IN p_estado_id INT,
    IN p_turno_id INT
)
BEGIN
    UPDATE tb_usuario
    SET correo = COALESCE(p_correo, correo),
        password = COALESCE(p_password, password),
        telefono = COALESCE(p_telefono, telefono),
        nombre = COALESCE(p_nombre, nombre),
        apellido = COALESCE(p_apellido, apellido),
        rol_id = COALESCE(p_rol_id, rol_id),
        estado_id = COALESCE(p_estado_id, estado_id),
        turno_id = COALESCE(p_turno_id, turno_id),
        fecha_actualizado = NOW()
    WHERE id = p_id;
END //

DELIMITER //
CREATE PROCEDURE sp_eliminar_usuario(
    IN p_id BIGINT
)
BEGIN
    DECLARE exit handler for sqlexception
    BEGIN
        -- Manejar el error de clave externa
        SELECT 'El usuario no puede ser eliminado debido a que cuenta con registros asociados a su ID' AS mensaje;
    END;

    -- Eliminar el usuario y manejar cualquier error que ocurra
    DELETE FROM tb_usuario WHERE id = p_id;

    SELECT 'Usuario eliminado exitosamente' AS mensaje;
END //
-- call sp_eliminar_usuario(3)

delimiter //
create procedure sp_actualizar_estado_usuario(in iduser int, in idest int)
begin
	update tb_usuario set estado_id = idest
    where id = iduser;
end //

-- *****************************************************************************************************************
-- Procedimientos almacenados para PEDIDO Y DETALLE PEDIDO 
-- *****************************************************************************************************************

DELIMITER //

CREATE PROCEDURE sp_listar_pedidos()
BEGIN
    SELECT id, fecha, costoTotal, usuario_id, proveedor_id
    FROM tb_pedido;
END //

DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_insertar_pedido(
    IN p_fecha DATE,
    IN p_costoTotal decimal(10,2),
    IN p_usuario_id INT,
    IN p_proveedor_id INT
)
BEGIN
    INSERT INTO tb_pedido (fecha, costoTotal, usuario_id, proveedor_id)
    VALUES (p_fecha, p_costoTotal, p_usuario_id, p_proveedor_id);
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_editar_pedido(
    IN p_pedido_id INT,
    IN p_fecha DATE,
    IN p_costoTotal decimal(10,2),
    IN p_usuario_id INT,
    IN p_proveedor_id INT
)
BEGIN
    UPDATE tb_pedido
    SET fecha = p_fecha,
        costoTotal = p_costoTotal,
        usuario_id = p_usuario_id,
        proveedor_id = p_proveedor_id
    WHERE id = p_pedido_id;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_eliminar_pedido(
    IN p_pedido_id INT
)
BEGIN
    DELETE FROM tb_pedido WHERE id = p_pedido_id;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_insertar_detalle_pedido(
    IN p_cantidad INT,
    IN p_precioUnitario DOUBLE,
    IN p_pedido_id INT,
    IN p_producto_id INT
)
BEGIN
    INSERT INTO tb_detalle_pedido (cantidad, precioUnitario, pedido_id, producto_id)
    VALUES (p_cantidad, p_precioUnitario, p_pedido_id, p_producto_id);
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_editar_detalle_pedido(
    IN p_id_detalle_pedido INT,
    IN p_cantidad INT,
    IN p_precioUnitario DOUBLE,
    IN p_pedido_id INT,
    IN p_producto_id INT
)
BEGIN
    UPDATE tb_detalle_pedido
    SET cantidad = p_cantidad,
        precioUnitario = p_precioUnitario,
        pedido_id = p_pedido_id,
        producto_id = p_producto_id
    WHERE id = p_id_detalle_pedido;
END //
DELIMITER ;


DELIMITER //

CREATE PROCEDURE sp_registrar_pedido(
    IN p_fecha DATE,
    IN p_costoTotal decimal(10,2),
    IN p_usuario_id INT,
    IN p_proveedor_id INT
)
BEGIN
    INSERT INTO tb_pedido (fecha, costoTotal, usuario_id, proveedor_id)
    VALUES (p_fecha, p_costoTotal, p_usuario_id, p_proveedor_id);
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE sp_buscar_pedido_por_codigo(
    IN p_codigo INT
)
BEGIN
    SELECT id, fecha, costoTotal, usuario_id, proveedor_id
    FROM tb_pedido
    WHERE id = p_codigo;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE sp_filtrar_pedido(
    IN p_pedido_id INT
)
BEGIN
    SELECT id, fecha, costoTotal, usuario_id, proveedor_id
    FROM tb_pedido
    WHERE id = p_pedido_id;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE sp_consultar_pedido_codigo(
    IN p_codpedido INT
)
BEGIN
    SELECT id, fecha, costoTotal, usuario_id, proveedor_id
    FROM tb_pedido
    WHERE id = p_codpedido;
END //

-- ##################################################################################################
-- Zona experimental
-- ##################################################################################################
-- ##################################################################################################
-- Zona segura
-- ##################################################################################################
-- Inserts
-- insertar Turnos
INSERT INTO tb_turno VALUES (1, 'mañana'), (2, 'tarde'), (3,'noche');

-- insertar estados
INSERT INTO tb_estado VALUES (1,'activo'),(3,'eliminado'),(2,'inactivo');

-- insertar modulos
INSERT INTO tb_modulo VALUES (1,'role'),(2,'usuario'),(3,'producto'),(4,'categoria_producto'),(5,'proveedor'),(6,'pedido');

-- insertar permisos
INSERT INTO tb_permiso VALUES (1,'agregar_rol',1),(2,'editar_rol',1),(3,'eliminar_rol',1),(4,'ver_rol',1),(5,'buscar_rol',1),(6,'agregar_usuario',2),(7,'editar_usuario',2),(8,'eliminar_usuario',2),(9,'ver_usuario',2),(10,'buscar_usuario',2),(11,'agregar_producto',3),(12,'editar_producto',3),(13,'eliminar_producto',3),(14,'ver_producto',3),(15,'buscar_producto',3),(16,'agregar_categoria_producto',4),(17,'editar_categoria_producto',4),(18,'eliminar_categoria_producto',4),(19,'ver_categoria_producto',4),(20,'buscar_categoria_producto',4);

-- insertar roles
INSERT INTO tb_rol VALUES (1,'admin'),(2,'empleado');

-- insertar roles con permiso
INSERT INTO tb_rol_permiso VALUES (23,1,1),(24,1,2),(25,1,3),(26,1,4),(27,1,5),(28,1,6),(29,1,7),(30,1,8),(31,1,9),(32,1,10),(33,1,11),(34,1,12),(35,1,13),(36,1,14),(37,1,15),(38,1,16),(39,1,17),(40,1,18),(41,1,19),(42,1,20),(43,2,14),(44,2,15);

-- Insertar usuarios
INSERT INTO tb_usuario (correo, password, telefono, nombre, apellido, fecha_alta, fecha_actualizado, rol_id, estado_id, turno_id)
VALUES 
    ('juan@example.com', '$2y$12$cj3/SNIEMQUqEeZjO.btxuQav0U.ySoHv35rOKb1IGcLVx3p1tkIO', 963754812, 'Juan', 'Perez', '2024-05-06 02:19:51', '2024-05-06 02:19:51', 2, 1, NULL),
    ('maria@example.com', '$2y$12$V59gK64Xx.awhZU9v0MnUOCS8h8At6VY69k2vzV5UMjA4EbWm8tUO', 964578132, 'María', 'García', '2024-05-06 02:19:51', '2024-05-06 02:19:51', 2, 1, NULL),
    ('admin@minimarketlaravel.io', '$2y$12$V59gK64Xx.awhZU9v0MnUOCS8h8At6VY69k2vzV5UMjA4EbWm8tUO', 946758213, 'Admin', '', '2024-05-06 02:19:53', '2024-05-06 02:19:53', 1, 1, NULL);


-- Insertar proveedores de productos
INSERT INTO tb_proveedor (nombre, ruc, descripcion, telefono, correo, direccion, estado_id) VALUES 
('Distribuidora Alfa Enlatados', '22345678901', 'Proveedor de alimentos enlatados', '987954329', 'info@alfa.com', 'Calle Principal #123', 1),
('Distribuidora frut S.A.', '28768432101', 'Proveedor de frutas', '954321987', 'ventas@productosfrescos.com', 'Avenida Central #456', 1),
('Bebidas Refrescantes Ltda.', '26789052301', 'Proveedor de bebidas gaseosas y aguas embotelladas', '921654981', 'pedidos@bebidasrefrescantes.com', 'Calle Secundaria #789', 1),
('PepsiCO S.A.', '20987654721', 'Proveedor de golosinas, chocolates y snacks', '989012345', 'contacto@dulcesygolosinas.com', 'Avenida Sur #234', 1),
('Distribuidora FyN Limpieza', '23456719012', 'Proveedor de productos de limpieza, detergentes y desinfectantes', '919344678', 'ventas@articulosdelimpieza.com', 'Calle Norte #567', 1),
('Lácteos Deliciosos S.A.', '28765472109', 'Proveedor de productos lácteos frescos y saludables', '987654321', 'ventas@lacteosdeliciosos.com', 'Avenida Norte #456', 1),
('Verduras Orgánicas Ltda.', '21934667890', 'Proveedor de verduras frescas y orgánicas', '912395698', 'ventas@verdurasorganicas.com', 'Calle Verde #789', 1),
('Cervecería Backus S.A.', '21294567810', 'Proveedor de cervezas de alta calidad y variedad', '992345678', 'contacto@cervezabackus.com', 'Avenida Cervecera #123', 1),
('Productos de Higiene Personal S.A.', '22375688971', 'Proveedor de productos de higiene personal, como jabones, champús y cremas', '123456789', 'ventas@higienepersonal.com', 'Calle Higiene #456', 1),
('Heladería Donofrio S.A.', '22347618901', 'Proveedor de helados artesanales y postres helados', '991476189', 'ventas@heladeriadelicias.com', 'Calle Principal #990', 1),
('Panadería PanDuro S.A.', '22345078501', 'Proveedor de productos de panadería frescos y variados', '983416719', 'ventas@panaderiapanDulce.com', 'Calle del Pan #789', 1),
('Carnes y Pescados Frescos S.A.', '28795032009', 'Proveedor de carnes y pescados frescos y de calidad', '987154821', 'ventas@carnespescadosfrescos.com', 'Avenida del Mar #789' , 2);

-- Insertar categorías de productos para un minimarket
INSERT INTO tb_categoria_producto (nombre) VALUES 
('Enlatados'),
('Frutas'),
('Bebidas'),
('Snacks y golosinas'),
('Productos de limpieza'),
('Lácteos'),
('Verduras'),
('Cervezas'),
('Cuidado personal'),
('Helados'),
('Panadería'),
('Carnes y pescados');

-- Insertar productos relacionados con las categorías ya definidas
INSERT INTO tb_producto (nombre, precio_compra, precio_venta, stock_disponible, codigoBarras, categoria_producto_id, estado_id) VALUES 
('Atún enlatado', 3.1, 3.99, 50, '0123456789099', 1, 1),
('Sopa de fideos enlatada', 0.8, 1.75, 80, '1234567890188', 1, 1),
('Maíz enlatado', 0.95, 1.49, 60, '2345678901277', 1, 1),
('Manzanas', 1.98, 2.99, 50, '1234567890166', 2, 1),
('Plátanos', 0.97, 1.75, 80, '2345678901255', 2, 1),
('Naranjas', 0.85, 1.49, 60, '3456789012344', 2, 1),
('Coca-Cola',1.2, 1.99, 100, '1234567890133', 3, 1),
('Pepsi',0.94,  1.75, 120, '2345678901222', 3, 1),
('Sprite',0.80, 1.49, 80, '3456789012311', 3, 1),
('Papas Fritas',0.96, 1.99, 100, '1234567890197', 4, 1),
('Galletas',0.95, 1.75, 120, '2345678901264', 4, 1),
('Chocolate',0.60, 1.49, 80, '3456789012331', 4, 1),
('Detergente líquido',1.63, 3.99, 50, '1994567890123', 5, 1),
('Lejía',1.62, 2.75, 80, '2345678901234', 5, 1),
('Limpiador multiusos',0.95, 1.99, 60, '3886789012345', 5, 1),
('Mantequilla',1.84, 2.25, 90, '4777890123456', 6, 1),
('Yogur natural',0.96, 1.75, 80, '2665678901234', 6, 1),
('Queso fresco',1.67, 3.99, 60, '3556789012345', 6, 1),
('Zanahorias',0.45, 0.99, 80, '8441234567890', 7, 1),
('Tomates',1.1, 1.49, 50, '7833123456789', 7, 1),
('Espinacas',0.96, 1.25, 70, '9022345678901', 7, 1),
('Pilsen',1.21, 2.99, 100, '1114567890123', 8, 1),
('Cristal',1.94, 3.25, 120, '2005678901234', 8, 1),
('Cusqueña',1.84, 3.49, 80, '3456798012345', 8, 1),
('Champú',2.61, 4.99, 50, '1234561290123', 9, 1),
('Jabón de baño',1.6, 1.75, 80, '2345673901234', 9, 1),
('Crema hidratante',2.63, 3.49, 60, '3456749012345', 9, 1),
('Helado de vainilla',1.95, 2.99, 70, '4567870123456', 10, 1),
('Helado de chocolate',2.1, 3.25, 80, '5678081234567', 10, 1),
('Helado de fresa',1.94, 3.49, 90, '6789010645678', 10, 1),
('Pan de molde',0.98, 1.99, 50, '1234505890123', 11, 1),
('Croissants',0.57, 1.25, 60, '2345678041234', 11, 1),
('Baguettes',1.21, 2.49, 40, '3456780312345', 11, 1),
('Filete de pollo',3.58, 5.99, 70, '4567894023456', 12, 1),
('Filete de salmón',7.12, 8.25, 80, '5678900034567', 12, 1),
('Lomo de cerdo',5.12, 6.49, 90, '6789011745678', 12, 1);


-- Insert para los pedidos y sus detalles
-- pedido 1
INSERT INTO tb_pedido (fecha, costoTotal, usuario_id, proveedor_id)
VALUES ('2024-04-11', 15.50, 2, 2);

INSERT INTO tb_detalle_pedido (cantidad, precioUnitario, pedido_id, producto_id)
VALUES (2, 3.50, 1, 2);

INSERT INTO tb_detalle_pedido (cantidad, precioUnitario, pedido_id, producto_id)
VALUES (1, 2.50, 1, 5);

-- pedido 2
INSERT INTO tb_pedido (fecha, costoTotal, usuario_id, proveedor_id)
VALUES ('2024-04-10', 22.00, 3, 4);

INSERT INTO tb_detalle_pedido (cantidad, precioUnitario, pedido_id, producto_id)
VALUES (3, 1.80, 2, 7);

INSERT INTO tb_detalle_pedido (cantidad, precioUnitario, pedido_id, producto_id)
VALUES (2, 2.00, 2, 10);

INSERT INTO tb_detalle_pedido (cantidad, precioUnitario, pedido_id, producto_id)
VALUES (1, 10.00, 2, 12);

-- pedido 3
INSERT INTO tb_pedido (fecha, costoTotal, usuario_id, proveedor_id)
VALUES ('2024-04-09', 10.20, 3, 1);

INSERT INTO tb_detalle_pedido (cantidad, precioUnitario, pedido_id, producto_id)
VALUES (5, 2.50, 3, 1);

INSERT INTO tb_detalle_pedido (cantidad, precioUnitario, pedido_id, producto_id)
VALUES (2, 1.20, 3, 3);

-- pedido 4
INSERT INTO tb_pedido (fecha, costoTotal, usuario_id, proveedor_id)
VALUES ('2024-04-08', 18.70, 2, 3);

INSERT INTO tb_detalle_pedido (cantidad, precioUnitario, pedido_id, producto_id)
VALUES (1, 5.00, 4, 6);

INSERT INTO tb_detalle_pedido (cantidad, precioUnitario, pedido_id, producto_id)
VALUES (2, 3.50, 4, 8);

INSERT INTO tb_detalle_pedido (cantidad, precioUnitario, pedido_id, producto_id)
VALUES (1, 2.80, 4, 13);

-- Insert para tipo de comprobante
insert into tb_tipo_comprobante (comprobante) values
("factura"),
("boleta");

-- Insert para los metodos de pago
insert into tb_metodo_pago (metodo_pago) values
("efectivo"),
("tarjeta debito"),
("tarjeta credito"),
("Yape");

-- Insertar venta 1
INSERT INTO tb_venta (fecha_hora, impuesto, total, tipo_comprobante_id, metodo_pago_id, usuario_id)
VALUES ('2024-04-12 09:30:00', 1.50, 18.99, 1, 2, 2);

-- Detalles de la venta 1
INSERT INTO tb_detalle_venta (precio_unitario, subtotal, cantidad, producto_id, id_venta)
VALUES (2.99, 11.96, 4, 4, 1);

INSERT INTO tb_detalle_venta (precio_unitario, subtotal, cantidad, producto_id, id_venta)
VALUES (1.75, 1.75, 1, 11, 1);

-- Insertar venta 2
INSERT INTO tb_venta (fecha_hora, impuesto, total, tipo_comprobante_id, metodo_pago_id, usuario_id)
VALUES ('2024-04-12 12:45:00', 2.20, 10.24, 1, 3, 3);

-- Detalles de la venta 2
INSERT INTO tb_detalle_venta (precio_unitario, subtotal, cantidad, producto_id, id_venta)
VALUES (1.75, 5.25, 3, 8, 2);

INSERT INTO tb_detalle_venta (precio_unitario, subtotal, cantidad, producto_id, id_venta)
VALUES (1.75, 3.5, 2, 10, 2);

INSERT INTO tb_detalle_venta (precio_unitario, subtotal, cantidad, producto_id, id_venta)
VALUES (1.49, 1.49, 1, 12, 2);

-- ##################################################################################################
-- Zona segura
-- ##################################################################################################