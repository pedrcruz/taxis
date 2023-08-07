COPY zone (name)
    FROM PROGRAM 'cut -d "," -f 3 /csv/zone.csv'
    WITH (FORMAT CSV, HEADER);

COPY trip (pickup_datetime, dropoff_datetime, pickup_zone_id, dropoff_zone_id)
    FROM PROGRAM 'cut -d "," -f 3,4,7,8 /csv/green.csv'
    WITH (FORMAT CSV, HEADER);

COPY trip (pickup_datetime, dropoff_datetime, pickup_zone_id, dropoff_zone_id)
    FROM PROGRAM 'cut -d "," -f 3,4,7,8 /csv/yellow.csv'
    WITH (FORMAT CSV, HEADER);