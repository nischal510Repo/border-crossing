Download source code

Build the project:

Run the application:

Access the API:
The server will start at http://localhost:8080.

📖 API Usage
Find Route
Endpoint: GET /routing/{origin}/{destination}

Example Request:
GET http://localhost:8080/routing/CZE/ITA

Example Response:

🧪 Recommended Test Cases
Direct Neighbors: FRA/ESP

Long Route: ZAF/TUN (Africa traversal)

Impossible Route: USA/GBR (Should return 400 Bad Request)