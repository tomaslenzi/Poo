# 

Un bazar desea ofrecer a sus clientes, además de los productos
individuales, combos pre-armados con importantes descuentos. Cada
combo, puede agrupar productos sueltos u otros combos ya armados, sin
perder la estructura de qué producto pertenece a cada combo original. Por
ejemplo, los productos “pico decoración liso”, “pico decoración estrella”, y
“pico decoración plano” se agrupan en un combo llamado “picos de
decoración”. Luego puede existir un combo “combo decoración básico”,
que incluye, una “manga pastelera” y el combo “picos de decoración”.

Los productos poseen una lista de categorías, un peso y un precio. En el caso del combo, el precio queda
determinado por la suma de los precios de todos sus componentes, menos un 1,4% por cada producto contenido.
Se debe tener en cuenta que el descuento nunca debe superar el 50% del precio original del combo (si supera, el
descuento queda en 50%), a futuro ambos valores pueden variar, incluso ser distintos dependiendo del combo. El
peso de cada combo queda determinado por la suma de los pesos de todos sus componentes. Las categorías de un
combo se determinan como la unión, sin repetidos, de todas las categorías de los elementos que contienen.

A la hora de armar combos, el bazar establece ciertas condiciones sobre los componentes que se pueden incorporar
inicialmente a los mismos. Por ejemplo, que el componente que se agrega al combo posea una categoría dada y un
precio menor a $3000. Otros combos controlan que el componente a agregar posea la categoría dada, otros que el
precio no supere los $400, o incluso algunos combos que controlan que el peso sea superior a 250 gramos.
Igualmente, como la demanda va cambiando, este requisito se puede combinar y variar dinámicamente.

El bazar desea que se provean los siguientes servicios :
● Contar la cantidad total de productos que posee un combo, considerando todos los niveles de
agrupamiento.
● Retornar el producto con menor peso de un combo. Nota: debe ser un producto y no un combo.
● Realizar búsquedas de productos/combos. Las búsquedas retornan un listado de productos o combos que
cumplen ciertas condiciones. Por ejemplo:
o Todos los que tienen un peso superior a 300 gramos.
o Todos los que el precio no supere los 500 pesos.
o Todos los que posean la categoría “cocina”
o Los anteriores son solo algunos ejemplos de búsqueda, se pueden crear nuevas formas y
combinaciones lógicas de los anteriores.

Nota 1: En el caso de la búsqueda, si un combo cumple con lo que se está buscando, el combo en sí será
parte del resultado, en caso que no cumpla se propaga la búsqueda sobre los elementos que él contiene.
● Para facilitar el armado de nuevos combos, se desea poder obtener una copia restringida de un combo o un
producto. Esta copia debe respetar la estructura original, pero solo se incluyen elementos (productos o
combos) que:
o Tengan un peso superior a 400 gramos
o El precio sea igual a 300 pesos
o Posean la categoría “adorno”
o Los anteriores son solo algunos ejemplos de condiciones que deben cumplir los paquetes, se pueden
crear nuevas formas y combinaciones lógicas de los anteriores.

Nota 2: La copia obtenida debe respetar la estructura creada de combos, si se modifica cualquier valor de la
estructura copiada no se modifica el original. Si un combo queda vacío porque ningún producto cumple con la
condición impuesta para obtener la copia el mismo NO se incluye en la copia.
El bazar también quiere incluir dos tipos nuevos de combos: uno que se identifica como “Express”, el cual solo
acepta elementos que posean la categoría “Herramientas”; y otro que se identifica como “Promocionales”, en el cual
el precio del mismo se calcula siempre como el promedio de los precios que él contiene (no va a cambiar nunca la
forma).
