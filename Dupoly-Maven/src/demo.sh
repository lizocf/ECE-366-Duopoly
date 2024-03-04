curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"user_name": "Clarence"}' \
  http://localhost:8080/createNewAccount
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"user_name": "Jeffery"}' \ 
  http://localhost:8080/createNewAccount
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"user_name": "TimmyJones"}' \
  http://localhost:8080/createNewAccount
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"game_code": "AS123"}' \     
  http://localhost:8080/createNewGame
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
    "user_id": "2",
    "game_id": "1"
          }' \
  http://localhost:8080/createPlayerInGame
curl --header "Content-Type: application/json" \
  --request GET \
  --data '{
    "space" : "1",
    "user_id": "2",
    "game_id": "1"
          }' \
  http://localhost:8080/createOwnedProperty
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
    "user_id": "2",
    "game_id": "1",
    "profit" : "-1500"
          }' \
  http://localhost:8080/updateCash
  