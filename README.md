
# ProyectoDespacho

Sistema de gestión de despachos basado en una arquitectura de microservicios, desarrollado con **Angular**, **Spring Boot** y **Google Cloud Platform (GCP)**.

Este proyecto fue desarrollado como parte de la asignatura **Cloud Native I** de la carrera de Ingeniería en Informática, aplicando principios de arquitectura cloud-native, autenticación mediante JWT, contenedores Docker y despliegue sobre Google Cloud.

---

# Objetivos

- Implementar una arquitectura basada en microservicios.
- Consumir servicios REST desde una aplicación Angular.
- Implementar autenticación y autorización mediante JWT.
- Desplegar servicios en Google Cloud Platform.
- Utilizar Docker para contenerizar todos los componentes.
- Centralizar el acceso a los microservicios mediante API Gateway.

---

# Arquitectura

```text
                    Usuario
                       │
                       ▼
                Angular Frontend
                       │
            Firebase Authentication
                       │
                  JWT Bearer Token
                       │
                       ▼
               Google API Gateway
                       │
         ┌─────────────┼─────────────┐
         ▼             ▼             ▼
   Auth Service   Usuario Service   Despacho Service
         │             │             │
         └─────────────┼─────────────┘
                       │
                  PostgreSQL
              (Docker Container)
```

---

# Tecnologías

## Frontend

- Angular 21
- Angular Material
- TypeScript

## Backend

- Java 21
- Spring Boot
- Spring Security
- JWT
- Maven

## Base de Datos

- PostgreSQL

## Contenedores

- Docker
- Docker Compose

## Cloud

- Google Cloud Platform
- Compute Engine
- API Gateway
- Cloud IAM
- Cloud Logging
- Secret Manager

---

# Estructura del Proyecto

```
ProyectoDespacho/
│
├── frontend/
│   └── angular-app/
│
├── services/
│   ├── auth-service/
│   ├── usuario-service/
│   └── despacho-service/
│
├── database/
│
├── gateway/
│
├── docs/
│
├── docker-compose.yml
│
├── README.md
│
└── .gitignore
```

---

# Microservicios

## Auth Service

Responsable de:

- Inicio de sesión
- Registro de usuarios
- Emisión de JWT
- Validación del Token

---

## Usuario Service

Responsable de:

- Administración de usuarios
- Gestión de perfiles
- Gestión de roles

---

## Despacho Service

Responsable de:

- Crear despachos
- Consultar despachos
- Actualizar estado
- Asignar conductor

---

# Flujo de Autenticación

```text
Usuario

↓

Angular

↓

Firebase Authentication

↓

JWT

↓

API Gateway

↓

Auth Service

↓

Usuario Service

↓

Despacho Service
```

---

# Roles

- ADMIN
- OPERADOR
- CONDUCTOR

---

# Estados del Despacho

- CREADO
- ASIGNADO
- EN_RUTA
- ENTREGADO
- CANCELADO

---

# Puertos

| Servicio | Puerto |
|----------|--------:|
| Angular | 4200 |
| Auth Service | 8081 |
| Usuario Service | 8082 |
| Despacho Service | 8083 |
| PostgreSQL | 5432 |

---

# Variables de Entorno

```env
POSTGRES_DB=proyecto_despacho

POSTGRES_USER=postgres

POSTGRES_PASSWORD=postgres

JWT_SECRET=ChangeThisSecret

JWT_EXPIRATION=3600000
```

---

# Ejecución

## Clonar el repositorio

```bash
git clone https://github.com/<usuario>/ProyectoDespacho.git
```

## Ingresar al proyecto

```bash
cd ProyectoDespacho
```

## Levantar la aplicación

```bash
docker compose up -d
```

---

# Equipo

Proyecto desarrollado para la asignatura **Cloud Native I**.

Carrera: Ingeniería en Informática.

---

# Licencia

Proyecto desarrollado con fines académicos.