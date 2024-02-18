CREATE TABLE customer(
    id          serial       PRIMARY KEY,
    fio         TEXT            NOT NULL,
    phone       TEXT,
    address     TEXT,
    created     timestamp
);

INSERT INTO customer (fio, phone, address, created) VALUES (':fio', ':phone', ':address', '1950-01-01') RETURNING ID;
UPDATE customer SET fio = ':fio', address = ':address', phone = ':phone' WHERE id = 26;