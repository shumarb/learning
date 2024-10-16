# REST APIs

## Overview
`REST API` (Representational State Transfer Application Programming Interface) is a software architectural style that facilitates communication between a `client` and `server` via a `HTTP` (HyperText Transfer Protocol).
The client sends a `request` to the server, and the server processes the request and returns a `response`, using standard HTTP methods like `GET`, `POST`, `PUT`, and `DELETE` to perform operations on resources in the server.

## Key Terms
- **Client**: The entity sending requests to the server.
- **Server**: The system processing requests from the client and sending responses to the client.
- **Request**: A message sent by the client to the server seeking data or an action.
- **Response**: A message sent from the server to the client containing the result of the request.
- **Resource**: A data object that can be accessed or manipulated via a REST API. A resource is identified by a `Uniform Resource Identifier` (Eg: /code/1 for a code with an id value of 1).
- **HTTP**: A protocol used for communication between a `client` and a `server` in a REST API. This comprises these methods:
  - `GET`: Retrieve a resource from the server.
  - `POST`: Create a new resource on the server.
  - `PUT`: Update an existing resource on the server.
  - `DELETE`: Remove a resource from the server.

## Importance
- **Simplicity**: Easy to understand and implement using standard HTTP methods (**GET**, **POST**, **PUT**, **DELETE**).
- **Statelessness**: Each request is independent, with no session information stored in the server, facilitating scalability.
- **Scalability**: Statelessness allows requests to be handled independently, enabling easy scaling by distributing requests across multiple servers. 
- **Flexibility**: Supports multiple data formats (eg: JSON, XML) and works across multiple environment (web, mobile).
- **Interoperability**: Works over HTTP, making it compatible with various programming languages (eg: Java, Python) across multiple platforms (eg: Linux, macOS).

## Implementation
1. The client sends an HTTP request (comprising an HTTP method and a resource) to the server.
2. The server processes the HTTP request by mapping the server maps the `HTTP method` to the appropriate `CRUD` operation. 
   - `GET` method corresponds to a `READ` operation.
   - `POST` method corresponds to a `CREATE` operation.
   - `PUT` method corresponds to a `UPDATE` operation.
   - `DELETE` method corresponds to a `DELETE` operation.
3. The server sends an HTTP response to the client comprising the following:
   - `Status Line`: The `status code` and `status message` indicating the result of the processing of the `response`.
   - `Headers`: Additional information about the `response` (Eg: Content type, metadata such as cache control).
   - `Body` (Optional): Data requested by the client via the `request` (Eg: JSON). 

## Status Line
A `status line` is part of an HTTP response from the server to the client.

### Categories
- 1xx: Informational
- 2xx: Success
- 3xx: Redirection
- 4xx: Client Error
- 5xx: Server Error

### Examples
| Status Code & Status Message | Description                                                                                                                       |
|------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| 200 OK                       | Request has succeeded.                                                                                                            |
| 201 Created                  | Request has succeeded and a new resource has been created.                                                                        |
| 400 Bad Request              | Server does not understand request due to incorrect syntax.                                                                       |
| 403 Forbidden                | Unauthorized request. The client does not have access rights to the content, though the client's identity is known to the server. |
| 404 Not Found                | The server cannot find the requested resource.                                                                                    |
| 500 Internal Server Error    | The server encountered an unexpected condition that prevents it from fulfilling the request.                                      |
| 501 Not Implemented          | The HTTP method is not supported by the server and hence cannot be handled.                                                       |
| 503 Service Unavailable      | The server is not ready to handle the request.                                                                                    |
