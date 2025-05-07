
# 💈 Sistema de Gestión para Barbería

Sistema completo para la administración de una barbería con múltiples funcionalidades que permiten gestionar turnos, clientes, empleados, finanzas, stock y sucursales de forma eficiente.

## ✅ Funcionalidades principales

- 📅 Agenda de turnos por cliente y fecha
- 👥 Registro de clientes y empleados
- 💸 Gestión de cuentas corrientes
- 🧾 Control de caja diaria
- 📦 Control de stock por sucursal y depósito
- 🚚 Abastecimiento de sucursales desde depósito central
- 🔐 Gestión de usuarios con permisos
- 🕓 Historial de movimientos por sucursal y general

## 🛠️ Tecnologías utilizadas

- Lenguaje: **Java**
- Base de datos: **MySQL**
- IDE: **NetBeans**
- Interfaz gráfica: **Swing**

## 🗂️ Estructura del proyecto

```
/barberia/
├── src/                 # Código fuente Java
├── database/            # Contiene el archivo barberia.sql para importar en MySQL
│   └── barberia.sql
├── README.md
└── .gitignore
```

## 🛠️ Instalación

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/medchajari/barberia.git
   ```

2. Abrir el proyecto en **NetBeans**.

3. Importar la base de datos:
   - Crear una base de datos llamada `barberia` en MySQL.
   - Importar el archivo `database/barberia.sql`.

4. Configurar los parámetros de conexión a la base de datos (usuario, contraseña, etc.) en el código.

5. Ejecutar desde la clase principal.

## 🔐 Acceso de ejemplo

- Usuario: `admin`
- Contraseña: `admin123`
> *Modificar estos datos desde el panel de usuarios.*

## 👤 Autor

**Martin Esteban De Los Santos**  
📧 mar7incitoo@gmail.com  
📱 +54 3456 468873  
🌐 [GitHub - medchajari](https://github.com/medchajari)

---

> Este proyecto forma parte de mis desarrollos como **Desarrollador Full Stack en Java** con experiencia en sistemas reales para laboratorios, barberías, seguros, transporte y más.
