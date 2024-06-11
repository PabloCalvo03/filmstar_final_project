restart-db:
	docker exec -i src-api-mysqldb-1 mysql -u root -proot -e "DROP DATABASE IF EXISTS filmstar_db; CREATE DATABASE filmstar_db; USE filmstar_db;"

migrate:
	docker exec -i src-api-mysqldb-1 mysql -u root -proot filmstar_db < ./fixtures/fixture.sql

start: 
	docker compose up
