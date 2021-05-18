/*
1.	Mostrar el número de ventas de cada producto, ordenado de más a menos ventas.*/
		
	SELECT "Productos"."Producto", "Productos"."Nombre", COUNT("Venta"."Producto") AS "Cantidad" FROM "Productos" LEFT JOIN "Venta" ON "Productos"."Producto" = "Venta"."Producto" GROUP BY "Productos"."Producto", "Productos"."Nombre" ORDER BY COUNT("Venta"."Producto") DESC

/*2.	Obtener un informe completo de ventas, indicando el nombre del cajero que realizo la venta, nombre y precios de los productos vendidos, y el piso en el que se encuentra la máquina registradora donde se realizó la venta.*/

	SELECT "Cajeros"."NomApl" as CAJERO, "Maquinas_Registradroas"."Piso", "Productos"."Nombre" AS PRODUCTO, "Productos"."Precio" FROM "Cajeros" INNER JOIN "Venta" ON "Cajeros"."Cajero" = "Venta"."Cajero" INNER JOIN "Maquinas_Registradroas" ON "Venta"."Maquina" = "Maquinas_Registradroas"."Maquina" INNER JOIN "Productos" ON "Venta"."Producto" = "Productos"."Producto" ORDER BY "Precio" DESC, "Productos"."Nombre"


/*3.	Obtener las ventas totales realizadas en cada piso.*/

	SELECT "Piso", SUM("Precio") FROM "Venta", "Productos" P, "Maquinas_Registradroas" M WHERE "Venta"."Producto" = P."Producto" AND "Venta"."Maquina" = M."Maquina" GROUP BY "Piso"

/*4.	Obtener el código y nombre de cada cajero junto con el importe total de sus ventas.*/

	SELECT "Cajeros"."Cajero", "Cajeros"."NomApl", SUM("Precio") as "Suma" FROM "Productos" INNER JOIN ("Cajeros" LEFT JOIN "Venta" ON "Venta"."Cajero" = "Cajeros"."Cajero") ON "Venta"."Producto" = "Productos"."Producto" GROUP BY "Cajeros"."Cajero"


/*5.	Obtener el código y nombre de aquellos cajeros que hayan realizado ventas en pisos cuyas ventas totales sean inferiores a los 5000 pesos.*/

	SELECT "Cajeros"."Cajero", "Cajeros"."NomApl", SUM("Precio") as "Suma" FROM "Productos" INNER JOIN ("Cajeros" LEFT JOIN "Venta" ON "Venta"."Cajero" = "Cajeros"."Cajero") ON "Venta"."Producto" = "Productos"."Producto" GROUP BY "Cajeros"."Cajero" HAVING SUM("Precio") < 5000

