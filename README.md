# Mood Tracker

## Description

Mood Tracker is a colorful and responsive calendar that can be used as a personal journal and for tracking moods. Simply click a day in your calendar to set the mood and describe your thoughts on that day! The first line of your description will serve as a preview on the front face of your calendar for that day.

## Preview
<img width="1030" alt="Screen Shot 2022-01-26 at 12 48 33 AM" src="https://user-images.githubusercontent.com/3468354/151125089-ed0fe376-be20-4b08-855b-1d31fc1ce9c1.png">

## API

`Content-Type: application/json`

|Method|URI|Response|Request Body|Purpose|
|-|-|-|-|-|
|POST|`/register`|`ACCEPTED` or `BAD_REQUEST*` or `INTERNAL_SERVER_ERROR`|`User`|Registers a new user.
|GET|`/login`|`id: number`|-|-|
|GET|`/api/users/:id/moods`|`List<Mood>`|-|Get all moods for a user|
|PUT|`/api/users/:id/moods`|-|`Mood`|Saves a mood|

|`/register` Responses|
|-|
|`BAD_REQUEST: Name already taken.`|
|`BAD_REQUEST: Invalid username or password.`|

## REST Types
```ts
interface User {
    name:       string;
    password:   string;
}

interface Mood {
    date:       string; // yyyy-MM-dd
    value:      number; // Interval: [0, 4]
    description:string;
}
```

## Schema

<img width="419" alt="Screen Shot 2022-01-26 at 1 03 49 AM" src="https://user-images.githubusercontent.com/3468354/151125311-32dafa20-61ee-41cc-abf8-41fdd86ae5d4.png">

## Technologies

- `Angular` (Frontend Framework)
- `Spring Boot` (Backend Framework)
- `Spring Security` (Access Control)
- `Spring JPA` (Data Persistence)
- `Hibernate` (ORM)
- `MySQL` (DBMS)
- `Tomcat` (Webserver)
- `Gradle` (Build automation)
- `JUnit` (Testing)
- `Lombok` (Library)
