# ADR-001 — Stack tecnológico

## Estado
Pendiente

## Contexto
Necesitamos un stack simple para un MVP académico.

## Decisión
Usaremos:
- JS ?
- HTML
- CSS
- BOOSTRAP?  
- Java + bibliotecas web y necesarias
- PostgreSQL ?
- Docker
- Git

## Consecuencias
- Desarrollo más simple
- Menor complejidad que Spring Boot
- Fácil dockerización
- Menor curva de aprendizaje

## Arquitectura 
- Usaremos la menor posible, siempre y cuando no complique el trabajo en equipo
- API backend en java
- Front en js
- Un intermediario que le haga peticiones al back y las sirva al front para no mezclar responsabilidades
- Dcokerizar y probar en deploy si es posible el primer dia, así mismo que el compañero pruebe el docker y deploy y su integracion con git, trabajo en equipo y test
- Test basicos para que no se rompan las cosas del front una vez tenga algo definido