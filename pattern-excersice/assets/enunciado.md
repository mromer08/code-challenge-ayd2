# Sistema de Pedidos de Restaurante
Objetivo: Aplicar múltiples patrones de diseño (Strategy, Builder, Composite, Adapter y Command) en un sistema integrado para gestionar pedidos en un restaurante.

## Descripcion
El restaurante necesita modernizar su sistema de gestión de pedidos. 
Actualmente, el proceso es manual y propenso a errores.
Se desea una solución de software que permita:

-Crear pedidos personalizados con combinaciones variables de platos, bebidas y extras.
-Aplicar descuentos según el tipo de cliente o promociones temporales.
-Gestionar el flujo de pedidos: enviar a cocina, cancelar o modificar órdenes.
-Integrar con el sistema de cocina (un sistema de terceros), que usa un formato de datos distinto al del área de atención al cliente.

## Requerimientos:
### Construcción flexible de pedidos:

	Un pedido puede incluir múltiples items (plato principal, acompañamientos, bebidas, extras).
	Algunos items son obligatorios (ej: plato principal), otros opcionales.
	Debe soportar combos predefinidos (ej: "Menú infantil" = hamburguesa + papas + juguete).

### Cálculo de precios con descuentos:

	Descuento del 10% para clientes frecuentes.
	Promoción "Martes de Pasta": 15% de descuento en pastas los martes.
	Los descuentos no son acumulables.

### Gestión de acciones:
	Enviar pedido a cocina.
	Cancelar pedido (con confirmación).
	Posibilidad de deshacer la última acción.

### Comunicación con cocina:
	El sistema de cocina espera los pedidos en XML, pero la interfaz de atención al cliente trabaja con JSON.
	La conversión debe ser automática y transparente para el usuario.
	
	
## Entrega
	Código implementado.
	Diagrama de clases.
	Justificación de diseño explicando el por qué del uso de cada patron.

