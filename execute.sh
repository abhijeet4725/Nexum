# Building and packaging
mvn clean install -DskipTests

# Removing Unsynchronized container
docker compose down -v

# Enabling all the containers
docker compose up --build

