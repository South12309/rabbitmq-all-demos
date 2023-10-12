Contents
========

 * [Проект](#проект)
 * [Установка](#установка)
 * [Технологии](#технологии)
 * [Запуск](#запуск)
 * [Возможности](#возможности)
 * [Configuration](#configuration)
 * [Output Structure](#output-structure)
 * [Reinstalling Dotfiles](#reinstalling-dotfiles)
 * [Want to contribute?](#want-to-contribute)

### Проект

Сервис работы с сущностями для логистической компании “Грузоперевозки” (api).

### Установка

#### Method 1: [`pipx`](https://pypi.org/project/shallow-backup/)

```bash
$ pipx install shallow-backup
```

#### Method 2: Install From Source

```bash
$ git clone https://www.github.com/alichtman/shallow-backup.git
$ cd shallow-backup
$ pip3 install .
```

### Технологии
---

* Java 17
* Spring boot (REST-API)
* Spring Data JPA
* Spring Security
* Lombok
* Jwt
* Flyway
* H2
* maven
* mapstruct


### Запуск
---
При запуске происходит создание базы H2 в оперативной памяти и наполнение его тестовыми данными посредством flyway.


### Возможности
---
Сервис позволяет создавать, изменять, удалять, запрашивать клиентов, водителей, заказы, пользователей, исполнителей, транспорт.

---

Check out `CONTRIBUTING.md` and the `docs` directory.
