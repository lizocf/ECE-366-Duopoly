#!/bin/bash

# create Clarence account
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"user_name": "Clarence"}' \
  "http://localhost:8080/createNewAccount"

# create Jeffery account
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"user_name": "Jeffery"}' \
  "http://localhost:8080/createNewAccount"

# create TimmyJones
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"user_name": "TimmyJones"}' \
  "http://localhost:8080/createNewAccount"

# create new game with game code AS123
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"game_code": "AS123"}' \
  "http://localhost:8080/createNewGame"

# add player with user_id 1 into PlayerInGame
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
    "user_id": "1",
    "game_id": "1"
  }' \
  "http://localhost:8080/createPlayerInGame"

# add player with user_id 2 into PlayerInGame
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
    "user_id": "2",
    "game_id": "1"
  }' \
  "http://localhost:8080/createPlayerInGame"

# add player with user_id 3 into PlayerInGame
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
    "user_id": "3",
    "game_id": "1"
  }' \
  "http://localhost:8080/createPlayerInGame"

# user_id 2 will go first
# user_id 2 chooses their starting direction
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
    "game_id": "1",
    "user_id": "2",
    "direction": "right"
    }' \
    "http://localhost:8080/updateDir"

# user_if 2 rolls and moves 2
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
    "game_id": "1",
    "user_id": "2",
    "move_to": "2"
  }'
# user_id 2 chooses to purchase space 2
curl --header "Content-Type: application/json" \
  --request GET \
  --data '{
    "space" : "2",
    "user_id": "2",
    "game_id": "1"
  }' \
  "http://localhost:8080/createOwnedProperty"

# user_id 2 pays for space 2
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
    "user_id": "2",
    "game_id": "1",
    "profit" : "-500"
  }' \
  "http://localhost:8080/updateCash"

# user_id 1 chooses their starting direction
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
    "game_id": "1",
    "user_id": "1",
    "direction": "left"
    }' \
    "http://localhost:8080/updateDir"

# user_id 1 moves to space 6
curl --header "Content-Type: application/json:" \
  --request POST \
  --data '{
    "user_id": "1",
    "game_id": "1",
    "move_to": "54"
    }' \
    "http://localhost:8080/updatePos"

# user_id 1 chooses to purchase space 54
curl --header "Content-Type: application/json" \
  --request GET \
  --data '{
    "space" : "54",
    "user_id": "1",
    "game_id": "1"
  }' \
  "http://localhost:8080/createOwnedProperty"

# user_id 1 pays for space 54
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
    "user_id": "1",
    "game_id": "1",
    "profit" : "-500"
  }' \
  "http://localhost:8080/updateCash"

