# pg-test

A simple test program to help with figuring out this Kubernetes Postgres issue I've been having.

## Purpose

This should be only exposed locally on my LAN. It does a simple query of a Postgres table to retrieve a value from it. This is used to validate if Postgres is working. Ultimately it will narrow down whether my problem is Postgres itself, or the `sso-oauth2-server` and its communication with Postgres.

## How to Use

Go to `/message`. If you see `Hello World`, then Postgres is connected. If you see `Failure`, that means Postgres failed (check the logs for details on the failure).

## Database

Create the database in Postgres for this:

```sql
create database pg_test
```

Then run the `sql/schema.sql` file in it to create the table structure and setup data.