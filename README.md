# RuleEngine
GS1 Business Rule Engine

## Installation
Use the Docker Demon [Docker Compose](https://docs.docker.com/desktop/setup/install/windows-install/) to run the Application
 along with its PostgreSQL DB & PGAdmin.

1. Move to the application root directory
```bash
cd RuleEngine
```

2. Use docker compose command to make all the required containers and their networks up
```bash
docker compose up -d
```

3. Monitor the Rule Engine using docker compose (Optional)
```bash
docker compose logs -f ruleengine
```

4. Test the APIs using the attached Postman collection

## Sources
- GitHub Repository: https://github.com/mahShtayeh/RuleEngine
clone using:
```bash
git clone https://github.com/mahShtayeh/RuleEngine.git
```

- Docker image: https://hub.docker.com/r/mahshtayeh227/ruleengine
pull using:
```bash
docker pull mahshtayeh227/ruleengine
```
