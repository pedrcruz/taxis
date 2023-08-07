CREATE TABLE zone
(
    id   BIGSERIAL    NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE trip
(
    id               BIGSERIAL NOT NULL,
    pickup_datetime  timestamp NOT NULL,
    pickup_zone_id   BIGINT    NOT NULL,
    dropoff_datetime timestamp NOT NULL,
    dropoff_zone_id  BIGINT    NOT NULL,
    type             INT4      NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE trip
    ADD CONSTRAINT trip_pickup_zone_fkey FOREIGN KEY (pickup_zone_id) REFERENCES zone;
ALTER TABLE trip
    ADD CONSTRAINT trip_dropoff_zone_fkey FOREIGN KEY (dropoff_zone_id) REFERENCES zone;
