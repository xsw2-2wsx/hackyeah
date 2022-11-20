#!/bin/bash

BACKEND_URL="https://hackyeah.smartbikelocks.xyz/api"
# ====================== Users ======================

curl -X POST $BACKEND_URL/users -H "Content-type: application/json" -d '
{
  "id": 0,
  "email": "user1@email.com"
}
'

curl -X POST $BACKEND_URL/users -H "Content-type: application/json" -d '
{
  "id": 0,
  "email": "user2@email.com"
}
'

curl -X POST $BACKEND_URL/users -H "Content-type: application/json" -d '
{
  "id": 0,
  "email": "user2@email.com"
}
'

# ====================== Tags ======================
curl -X POST $BACKEND_URL/tags -H "Content-type: application/json" -d 'old bread'
curl -X POST $BACKEND_URL/tags -H "Content-type: application/json" -d 'broken ceramics'
curl -X POST $BACKEND_URL/tags -H "Content-type: application/json" -d 'cucumber'



# ====================== Instructions ======================

# ========== User 0 ==========

# Instruction 0
curl -X POST $BACKEND_URL/instructions -H "Content-type: application/json" -d '
{
	"id": 0,
	"creator": 0,
	"title": "Use dry brad for homemade breadcrumbs",
	"tags": [
		"old bread"
	],
	"additionalMaterials": [],
  "steps": [],
	"content": "Use dry brad for homemade breadcrumbs",
	"images": [
	  ""
	],
	"category": "DIY"
}
'

# Ratings for instruction 0
curl -X POST $BACKEND_URL/instructions/0/ratings -H "Content-type: application/json" -d '
{
	"userId": 1,
	"rating": 5,
	"comment": "Amazing idea!"
}
'

curl -X POST $BACKEND_URL/instructions/0/ratings -H "Content-type: application/json" -d '
{
	"userId": 2,
	"rating": 2,
	"comment": "Does not seem to be practical for me"
}
'

curl -X POST $BACKEND_URL/instructions/0/ratings -H "Content-type: application/json" -d '
{
	"userId": 2,
	"rating": 4,
	"comment": "great"
}
'

# Instruction 1
curl -X POST $BACKEND_URL/instructions -H "Content-type: application/json" -d '
{
	"id": 0,
	"creator": 0,
	"title": "Reuse for ingredients for Pappa al Pomodoro!",
	"tags": [
		"old bread"
	],
	"additionalMaterials": [],
  "steps": [],
	"content": "Reuse for ingredients for Pappa al Pomodoro!",
	"images": [
	  ""
	],
	"category": "DIY"
}
'

# Ratings for instruction 1
curl -X POST $BACKEND_URL/instructions/1/ratings -H "Content-type: application/json" -d '
{
	"userId": 1,
	"rating": 4,
	"comment": "Great job!"
}
'

curl -X POST $BACKEND_URL/instructions/1/ratings -H "Content-type: application/json" -d '
{
	"userId": 2,
	"rating": 3,
  "comment": "Ive seen better but its ok"
}
'

curl -X POST $BACKEND_URL/instructions/1/ratings -H "Content-type: application/json" -d '
{
	"userId": 3,
	"rating": 1,
  "comment": "Absolute terrible idea"
}
'

# ========== User 1 ==========

# Instruction 2
curl -X POST $BACKEND_URL/instructions -H "Content-type: application/json" -H "Content-type: application/json" -d '
{
	"id": 0,
	"creator": 1,
	"title": "Use dry brad as some food for animals",
	"tags": [
		"old bread"
	],
	"additionalMaterials": [],
  "steps": [],
	"content": "Use dry brad as food for some animals. Not birds tho!",
	"images": [
	  ""
	],
	"category": "DIY"
}
'

# Ratings for instruction 2
curl -X POST $BACKEND_URL/instructions/2/ratings -H "Content-type: application/json" -d '
{
	"userId": 1,
	"rating": 2,
  "comment": "Didnt like that but i guess it can be usefull"
}
'

curl -X POST $BACKEND_URL/instructions/2/ratings -H "Content-type: application/json" -d '
{
	"userId": 2,
	"rating": 4,
	"comment": "Niceee!"
}
'

curl -X POST $BACKEND_URL/instructions/2/ratings -H "Content-type: application/json" -d '
{
	"userId": 3,
	"rating": 3,
	"comment": "Fine, I guess"
}
'

# ========== User 2 ==========

# Instruction 3
curl -X POST $BACKEND_URL/instructions -H "Content-type: application/json" -H "Content-type: application/json" -d '
{
	"id": 0,
	"creator": 2,
	"title": "Use broken ceramics for plant drainage",
	"tags": [
		"broken ceramics"
	],
	"additionalMaterials": [],
	"steps": [],
	"content": "Broken ceramics can be used for drainage in you home plants. Mix the pieces with the soil and plant your plant in it!",
	"images": [
	  ""
	],
	"category": "DIY"
}
'

# Ratings for instruction 3
curl -X POST $BACKEND_URL/instructions/3/ratings -H "Content-type: application/json" -d '
{
	"userId": 1,
	"rating": 2,
  "comment": "Didnt like that but i guess it can be usefull"
}
'

curl -X POST $BACKEND_URL/instructions/3/ratings -H "Content-type: application/json" -d '
{
	"userId": 2,
	"rating": 4,
	"comment": "Niceee!"
}
'

curl -X POST $BACKEND_URL/instructions/3/ratings -H "Content-type: application/json" -d '
{
	"userId": 3,
	"rating": 3,
	"comment": "Fine, I guess"
}
'

