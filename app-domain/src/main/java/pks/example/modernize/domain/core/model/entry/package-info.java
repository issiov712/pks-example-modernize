/**
 * A sample package for financial schedules that occur over time and the entries along that timeline.
 *
 * Conceptually looking to have a a financial transaction mature from a simple date/amount payment plan
 * into a full general ledger transaction, sort of in-place.  A horizontal expansion of the type through
 * the population of additional fields and an in-place update of those fields.
 * 
 * Validation willbe done on the types to ensure it cannot be upgraded without proper values for the additional
 * fields.
 *  
 * Step 1.  Create the less specialized Entry.  This is like a simple payment schedule.
 * Step 2.  Create a LedgerEntry.from() the Entry by providing the Entry and the additional account information
 * 			required for a LedgerEntry type.
 * Step 3.	Maybe your can now post() the LedgerEntry to update the general ledger.
 * 
 * This creates a "maturation process" for the types as the system runs.  The TimeLine of Entries remains basically
 * the same list of enties, but some are in the future with less information, some are in the present (month) and
 * have more information.  Some are in the past and have even more information.  But the items on the TimeLine are
 * the same.  The objects are immutable and so they are different objects, but conceptually the Entry matures into
 * an historical LedgerEntry.
 * 
 * If the TimeLine is recalculated, then the old one is frozen and a completely new one is created.  But as time
 * moves ahead without a recalculation of the timeline the objects just mature to more comprehensive types.  This
 * could be seen, maybe, as additional columns in the database going from null to some value and a status/type field
 * changing value.
 * 
 * The Entries are also groups of Items and so different parts of a single transaction would be a separate item.
 * 
 * Example:  A Loan with two (2) payments might be represented as the following:
 * 
 * 	As proposed:
 * 		1. Entry - <date-scheduled> $30 funds to  customer
 * 			EntryItem - $30 > customer
 * 		2. Entry - <date-scheduled> $16 payment from customer 
 * 			EntryItem - $15 < customer principal
 * 			EntryItem - $ 1 < customer interest
 * 		3. Entry - <date-scheduled> $16 payment from customer
 * 			EntryItem - $15 < customer principal
 * 			EntryItem - $ 1 < customer interest
 *
 *	As Funded:
 *		1. LedgerEntry - <date-scheduled> $30 funds to customer
 *			LedgerItem - <date-effective>, <date-posted>, <date-closed>
 *				debit  $30 account 99.12.33, project 88.001, orgUnit OWNR.33.221
 *				credit $30 account 01.55.12, project 00.001, orgUnit CUST.001.221
 * 		2. Entry - <date> $16 payment from customer 
 * 			EntryItem - $15 < customer principal
 * 			EntryItem - $ 1 < customer interest
 * 		3. Entry - <date> $16 payment from customer
 * 			EntryItem - $15 < customer principal
 * 			EntryItem - $ 1 < customer interest
 * 
 * 	After one (1) payment:
 *		1. LedgerEntry - <date-scheduled> $30 funds to customer
 *			LedgerItem - <date-effective>, <date-posted>, <date-closed>
 *				debit  $30.00 account 99.12.33, project 88.001, orgUnit OWNR.33.221	- investor capital
 *				credit $30.00 account 01.55.12, project 00.001, orgUnit CUST.001.221- customer account
 * 		2. LedgerEntry - <date-scheduled> $16 payment from customer 
 *			LedgerItem - <date-effective>, <date-posted>, <date-closed>
 *				debit  $15.00 account 99.12.33, project 88.001, orgUnit CUST.33.221 - principal from customer
 *				debit  $ 1.00 account 99.12.33, project 88.001, orgUnit CUST.33.221 - interest from customer
 *				credit $15.00 account 01.55.12, project 00.001, orgUnit OWNR.001.221- principal repayment to investor
 *				credit $ 0.90 account 99.12.33, project 88.001, orgUnit OWNR.33.221 - investor interest income
 *				credit $ 0.10 account 01.55.12, project 00.001, orgUnit BANK.001.221- bank fee as percentage of interest
 * 		3. Entry - <date> $16 payment from customer
 * 			EntryItem - $15.00 < customer principal
 * 			EntryItem - $ 1.00 < customer interest
 *
 * In the above you can get the sense for how the TimeLine is being matured.  Just need a "flow" of the Entry types
 * that makes sense across the lifecycle of the entries.
 * 
 * Also, the TimeLine could contain other items of importance that occur on dates throughout the relationship within
 * the given financial contract.  e.g. other things of value like options would be indicated by other types.  The various
 * types could be filtered out in returned lists to scope information to the business context, or even access control.
 * 
 * This scheme with a more vertical model allows a wide variety of situations without having many unused columns or the
 * need to change the structure as much. (?)
 * 
 */
package pks.example.modernize.domain.core.model.entry;