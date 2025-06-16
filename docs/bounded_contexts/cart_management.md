# Context draft

A cart aggregate has
 - an id 
 - a customer id, 
 - a list of line items.
Each line item has 
 - a product id, 
 - unit price
 - quantity

Unit price is detemined when adding a product to the cart. The cart retrives the product unit price by asking the product aggregate for its price which depends on the customer category

A customer can be a consumer/individual or a business. A consumer is its own category, the business can belong to a Small business category (when their treshold is below 10M) or a big business category( when their treshold is above 10M).

A consumer has 
 - an id, 
 - firstname and last name. They should not be null or empty

A business has 
 - an id which should not be empty or null. 
 - a company name (raison sociale), it should not be null or empty. - - has VAT (is optional)
   - if it has one it should be valid (to expand later).
 - has a SIREN should not be null, should respect the SIREN format (check wikipedia)


A product has
 - an id
 - a name
 - a pricing matrix (Consumer Category, com.capco.shared.domain.valueobject.Price)



