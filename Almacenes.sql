/*


 Source Server         : Test
 Source Server Type    : PostgreSQL
 Source Server Version : 130003
 Source Host           : localhost:5432
 Source Catalog        : almacen
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130003
 File Encoding         : 65001


*/
DROP database if exists almacen;
CREATE database almacen;

-- ----------------------------
-- Table structure for Cajeros
-- ----------------------------
DROP TABLE IF EXISTS "Cajeros";
CREATE TABLE "Cajeros" (
  "Cajero" int4 NOT NULL,
  "NomApl" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of Cajeros
-- ----------------------------
BEGIN;
INSERT INTO "Cajeros" VALUES (1, 'Victor Camacho');
INSERT INTO "Cajeros" VALUES (2, 'Jose Huerto');
INSERT INTO "Cajeros" VALUES (3, 'Leonel Hernandez');
INSERT INTO "Cajeros" VALUES (4, 'Jose Jimenez');
INSERT INTO "Cajeros" VALUES (5, 'Martha Sanchez');
INSERT INTO "Cajeros" VALUES (6, 'Alondra Juarez');
COMMIT;

-- ----------------------------
-- Table structure for Maquinas_Registradroas
-- ----------------------------
DROP TABLE IF EXISTS "Maquinas_Registradroas";
CREATE TABLE "Maquinas_Registradroas" (
  "Maquina" int4 NOT NULL,
  "Piso" int4
)
;

-- ----------------------------
-- Records of Maquinas_Registradroas
-- ----------------------------
BEGIN;
INSERT INTO "Maquinas_Registradroas" VALUES (1, 1);
INSERT INTO "Maquinas_Registradroas" VALUES (2, 1);
INSERT INTO "Maquinas_Registradroas" VALUES (3, 2);
INSERT INTO "Maquinas_Registradroas" VALUES (4, 2);
INSERT INTO "Maquinas_Registradroas" VALUES (5, 3);
INSERT INTO "Maquinas_Registradroas" VALUES (6, 3);
INSERT INTO "Maquinas_Registradroas" VALUES (7, 3);
COMMIT;

-- ----------------------------
-- Table structure for Productos
-- ----------------------------
DROP TABLE IF EXISTS "Productos";
CREATE TABLE "Productos" (
  "Nombre" varchar(100) COLLATE "pg_catalog"."default",
  "Precio" int4,
  "Producto" int4 NOT NULL
)
;

-- ----------------------------
-- Records of Productos
-- ----------------------------
BEGIN;
INSERT INTO "Productos" VALUES ('Zapatos', 100, 1);
INSERT INTO "Productos" VALUES ('Botas', 150, 2);
INSERT INTO "Productos" VALUES ('Zapatillas', 200, 3);
INSERT INTO "Productos" VALUES ('Camisa', 150, 4);
INSERT INTO "Productos" VALUES ('Pantalon', 200, 5);
INSERT INTO "Productos" VALUES ('Falda', 250, 6);
INSERT INTO "Productos" VALUES ('Vestido', 300, 7);
INSERT INTO "Productos" VALUES ('Sombrero', 150, 8);
INSERT INTO "Productos" VALUES ('Traje', 1500, 9);
INSERT INTO "Productos" VALUES ('Maletas', 2500, 10);
INSERT INTO "Productos" VALUES ('Cama', 3500, 11);
COMMIT;

-- ----------------------------
-- Table structure for Venta
-- ----------------------------
DROP TABLE IF EXISTS "Venta";
CREATE TABLE "Venta" (
  "Producto" int4,
  "Cajero" int4,
  "Maquina" int4
)
;

-- ----------------------------
-- Records of Venta
-- ----------------------------
BEGIN;
INSERT INTO "Venta" VALUES (1, 1, 2);
INSERT INTO "Venta" VALUES (3, 2, 1);
INSERT INTO "Venta" VALUES (4, 3, 3);
INSERT INTO "Venta" VALUES (5, 6, 4);
INSERT INTO "Venta" VALUES (7, 5, 1);
INSERT INTO "Venta" VALUES (6, 4, 5);
INSERT INTO "Venta" VALUES (7, 6, 4);
INSERT INTO "Venta" VALUES (6, 5, 2);
INSERT INTO "Venta" VALUES (2, 1, 3);
INSERT INTO "Venta" VALUES (2, 1, 3);
INSERT INTO "Venta" VALUES (2, 1, 3);
INSERT INTO "Venta" VALUES (5, 1, 3);
INSERT INTO "Venta" VALUES (9, 1, 2);
INSERT INTO "Venta" VALUES (10, 2, 1);
INSERT INTO "Venta" VALUES (9, 1, 3);
INSERT INTO "Venta" VALUES (10, 2, 1);
INSERT INTO "Venta" VALUES (11, 3, 5);
COMMIT;

-- ----------------------------
-- Primary Key structure for table Cajeros
-- ----------------------------
ALTER TABLE "Cajeros" ADD CONSTRAINT "Cajeros_pkey" PRIMARY KEY ("Cajero");

-- ----------------------------
-- Primary Key structure for table Maquinas_Registradroas
-- ----------------------------
ALTER TABLE "Maquinas_Registradroas" ADD CONSTRAINT "Maquinas_Registradroas_pkey" PRIMARY KEY ("Maquina");

-- ----------------------------
-- Primary Key structure for table Productos
-- ----------------------------
ALTER TABLE "Productos" ADD CONSTRAINT "Productos_pkey" PRIMARY KEY ("Producto");

-- ----------------------------
-- Foreign Keys structure for table Venta
-- ----------------------------
ALTER TABLE "Venta" ADD CONSTRAINT "Cajero" FOREIGN KEY ("Cajero") REFERENCES "Cajeros" ("Cajero") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "Venta" ADD CONSTRAINT "Maquina" FOREIGN KEY ("Maquina") REFERENCES "Maquinas_Registradroas" ("Maquina") ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE "Venta" ADD CONSTRAINT "Producto" FOREIGN KEY ("Producto") REFERENCES "Productos" ("Producto") ON DELETE RESTRICT ON UPDATE CASCADE;
