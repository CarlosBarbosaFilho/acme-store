# Acme Store -  MBA FullStack
* This project that  we be building to course of MBA Full Stack.

# Acme Store - Services

## Services Group
* Client Service
* Card Service
* Order Service
* Notification Service
* Fraud Service
* Product Service
* Inventory Service

#### Client Service: This service will be build to create, read, exclude and update all clients to system
* Requirements
  * Every customer needs to have one or more cards to send a purchase order
  * These cards must be checked for fraud and also their purchase limit.
  * Customer documents should be checked for restrictions, if any.
  * If the customer has some restrictions on his behalf, the notification service
    must be called to send all customer data and save in this service 
  * The card used in the customer's purchase, must be checked for fraud
  * The deletion/removal will be logical and not physical, will exist one flag to this
* Attributes Client
  * Name: String
  * Phone: Phone
  * Email: Email
  * Document: Document
  * Cards: List
#### Card Service: This service will be built to create cards, update card and list all cards per customer for the system
* Requirements
  * Card service must only update the card limit, and nothing else
  * Card service must list all cards for customer
  * Card service must verify the existence of fraud and the purchase limit
  * Card service must create customer card, customer must submit all data to create card such as income and required documents
  * Card service must list all the cards available for the client's credit request
* Attributes Client
  * Name: String
  * Flag: String
  * Number: Integer
  * Limit: BigDecimal
#### Order Service: This service will be build to send order client and your credentials of purchase, as value and list to products
* Requirements
  * Order service must receive the order and process this purchase, according to the customer and card data
  * Order service must create one order to customer
  * Order service must list all orders customer by document
#### Notification Service: This service will be created to send all notification in case of fraud and others causes on purchase process
* Attributes Notification
  * Date: Date
  * Client: (document and name client)
  * Card: (flag and name card)
  * Amount: Amount do purchase
* Requirements
  * Notification service must be the listener for all messages queued for notification
  * All notifications must contain all customer and card data and must be saved in the database of this service
  * The notification service must send a message to the customer to return the purchase status, this message must be sent
    to another queue, where the work order is listening.
#### Product Service: This service will be build to create, read, update and delete product on system
* Description to Service -
#### Inventory Service: This service will be build to store all product, hare to this products will be management on purchase process
* Description to Service -