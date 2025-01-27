# Finanzas Personales - Gestión de Ingresos, Gastos, Ahorros y Pagos

## Descripción

Este proyecto es una aplicación de gestión de finanzas personales que permite a los usuarios administrar sus ingresos, gastos, objetivos de ahorro y pagos mensuales. El sistema ofrece funcionalidades para registrar y visualizar los ingresos y gastos de los usuarios, así como también gestionar los pagos recurrentes y los objetivos de ahorro. Todo esto está almacenado en una base de datos **MongoDB**.

## Características

- **Gestión de Ingresos**: Los usuarios pueden registrar sus ingresos mensuales y clasificarlos según su fuente (por ejemplo, salario, freelance, inversión).
- **Gestión de Gastos**: Permite registrar y clasificar los gastos personales en diferentes categorías (por ejemplo, comida, entretenimiento, transporte, etc.).
- **Objetivos de Ahorro**: Los usuarios pueden establecer metas de ahorro, definir el monto objetivo y la fecha límite para alcanzarlo.
- **Pagos Mensuales**: Permite gestionar pagos recurrentes como suscripciones, alquileres o cualquier tipo de pago mensual.
- **Análisis Financiero**: Los usuarios pueden obtener reportes de sus ingresos, gastos y comparar con los objetivos de ahorro.
- **Autenticación y Seguridad**: La aplicación cuenta con seguridad integrada para la gestión de usuarios, con roles y permisos para proteger la información financiera.
- **Base de Datos MongoDB**: Toda la información del usuario (ingresos, gastos, ahorros, pagos) se almacena en MongoDB, lo que permite un manejo flexible de los datos.

## Modelo de Datos

La aplicación utiliza varios modelos para representar la información financiera:

1. **Ingreso**: Cada ingreso tiene un monto, una fuente y una fecha. Los ingresos pueden ser únicos o repetitivos (por ejemplo, salarios).
2. **Gasto**: Cada gasto se clasifica según su categoría y tiene un monto y una fecha. Los gastos pueden estar relacionados con compras diarias, pagos de servicios, etc.
3. **Objetivo de Ahorro**: Los usuarios pueden establecer objetivos de ahorro con un monto objetivo y una fecha límite. Esto ayuda a hacer un seguimiento de sus metas de ahorro.
4. **Pago Mensual**: Los pagos recurrentes que se hacen cada mes, como el alquiler, suscripciones o cualquier otro pago regular.

## Casos de Uso

### 1. Registrar un ingreso
Los usuarios pueden registrar su ingreso con detalles como el monto, la fuente y la fecha del ingreso.

### 2. Registrar un gasto
Los usuarios pueden registrar sus gastos con detalles como el monto, la categoría y la fecha.

### 3. Establecer un objetivo de ahorro
Los usuarios pueden definir un objetivo de ahorro, estableciendo la cantidad a ahorrar y la fecha límite para alcanzarlo.

### 4. Registrar un pago mensual
Los usuarios pueden gestionar pagos recurrentes como alquileres, suscripciones o pagos a crédito.

### 5. Obtener reportes financieros
La aplicación permite generar reportes que muestran los ingresos, gastos y el progreso hacia los objetivos de ahorro.

## Contribuciones

Este proyecto es de código abierto y las contribuciones son bienvenidas. Si deseas mejorar alguna funcionalidad o agregar una nueva, puedes seguir estos pasos para contribuir:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agrega una nueva funcionalidad'`).
4. Haz push a tu rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un pull request.

