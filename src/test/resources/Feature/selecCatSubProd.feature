#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: exitoSelCatSubProd
  I want to use this template for my feature file

  @tag1
  Scenario: Verify the path selected from menu-category-subcategory
    Given exito web page is open
    When user clicks on the main menu
    And user select the category
    And user select the subcategory
    And user add different products to shopping cart
    And user selects a quantity per product
    And user look at quantity on shopping car
    And user goes on shopping cart to check
    Then user validate that products name selected to be the same on shopping cart
    And user validate that products total price selected to be the same on shopping cart
    And user validate that  products quantites selected to be the same on shopping cart
    And user validate that  products number selected to be the same on shopping cart

  	        

   
