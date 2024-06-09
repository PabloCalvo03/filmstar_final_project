set-up:
	docker exec -i src-api-mysqldb-1 mysql -u root -proot -e "DROP DATABASE IF EXISTS filmstar_db; CREATE DATABASE filmstar_db; USE filmstar_db;"
	migrate

migrate:
	docker exec -i src-api-mysqldb-1 mysql -u root -proot filmstar_db < ./fixtures/fixture.sql

restart-database-with_fixtures:
	docker exec -i src-api-mysqldb-1 mysql -u root -proot filmstar_db < ./fixtures/restart_database_with_fixtures.sql

start: 
	docker compose up
