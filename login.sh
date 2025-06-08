#!/bin/bash

# Verifica se login e senha foram passados
if [ $# -ne 2 ]; then
  echo "Uso: ./login.sh <login> <senha>"
  exit 1
fi

LOGIN=$1
SENHA=$2

# Faz login e extrai o token
TOKEN=$(curl -s -X POST http://localhost:8081/login \
  -H "Content-Type: application/json" \
  -d "{\"login\": \"$LOGIN\", \"senha\": \"$SENHA\"}" \
  | jq -r '.token')

# Verifica se token foi obtido com sucesso
if [ "$TOKEN" == "null" ] || [ -z "$TOKEN" ]; then
  echo "❌ Falha ao obter token. Verifique o login/senha."
  exit 1
fi

# Exporta o token para uso no terminal atual
export TOKEN
echo "✅ Login realizado com sucesso. TOKEN exportado."
