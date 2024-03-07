# SmartFrango
API do projeto Smart Frango - Gerenciador De Treinos

## Colaboradores
Enzo Lafer Gallucci - RM551111

Kaiky Noriyuki Ishibashi - RM98876

## Tarefas

- [ ]  CRUD de Rotinas De Treino
- [ ]  CRUD de Treinamentos
- [ ]  CRUD de Medições
- [ ]  Dataset de Exercícios, Grupos Musculares, e Equipamentos
- [ ]  Calendário de Treinamentos
- [ ]  Lista de Treinamentos

## Documentação da API

### Endpoint
- [Listar Todas as Rotinas](#listar-todas-as-rotinas)
- [Cadastrar Rotina](#cadastrar-rotina)
- [Detalhes da Rotina](#detalhes-da-rotina)
- [Apagar Rotina](#apagar-rotina)
- [Atualizar Rotina](#atualizar-rotina)

### Listar Todas as Rotinas

`GET` /rotina

Retorna um array com todas as rotinas cadastradas.

#### Exemplo de Resposta

```js
[
    {
        "id": 1,
        "nome": "Peito",
        "exercicios": "Supino Reto, Supino Inclinado, Crucifixo, Peck Deck Fly."
    }
]
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados das rotinas foram retornados com sucesso
|401|Acesso negado. Você deve se autenticar

---

### Cadastrar Rotina

`POST` /rotina

Cria uma nova rotina com os dados enviados no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Um nome curto para a rotina.
|exercicios|string|❌|O nome do exercício de acordo com a Biblioteca de Exercícios

```js
{
    "nome": "Peito",
    "exercicios": "Supino Reto, Supino Inclinado, Crucifixo, Peck Deck Fly."
}
```

#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "Peito",
    "exercicios": "Supino Reto, Supino Inclinado, Crucifixo, Peck Deck Fly."
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|201|Rotina cadastrada com sucesso
|400|Dados enviados são inválidos. Verifique o corpo da requisição
|401|Acesso negado. Você deve se autenticar

---

### Detalhes da Rotina

`GET` /rotina/`{id}`

Retornar os detalhes da rotina com o `id` informado como parâmetro de path.

#### Exemplo de Resposta

```js
// requisição para /rotina/1
{
    "id": 1,
    "nome": "Peito",
    "exercicios": "Supino Reto, Supino Inclinado, Crucifixo, Peck Deck Fly."
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Os dados da rotina foram retornados com sucesso
|401|Acesso negado. Você deve se autenticar
|404|Não existe rotina com o `id` informado

---

### Apagar Rotina

`DELETE` /rotina/`{id}`

Apaga a rotina com o `id` especificado no parâmetro de path.

#### Códigos de Status

|código|descrição|
|------|---------|
|204|Rotina foi apagada com sucesso
|401|Acesso negado. Você deve se autenticar
|404|Não existe rotina com o `id` informado

---

### Atualizar Rotina

`PUT` /rotina/`{id}`

Altera dos dados da rotina especificada no `id`, utilizando as informações enviadas no corpo da requisição.

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:-----------:|---------|
|nome|string|✅|Um nome curto para a rotina.
|exercicios|string|✅|O nome do exercício de acordo com a Biblioteca de Exercícios
```js
{
    "nome": "Peito",
    "exercicios": "Supino Reto, Supino Inclinado, Crucifixo, Peck Deck Fly."
}
```
#### Exemplo de Resposta

```js
{
    "id": 1,
    "nome": "Peito",
    "exercicios": "Supino Reto, Supino Inclinado, Crucifixo, Peck Deck Fly."
}
```

#### Códigos de Status

|código|descrição|
|------|---------|
|200|Rotina alterada com sucesso
|400|Dados enviados são inválidos. Verifique o corpo da requisição
|401|Acesso negado. Você deve se autenticar
|404|Não existe rotina com o `id` informado

---
