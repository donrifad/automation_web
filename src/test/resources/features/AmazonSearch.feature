Feature: Navigate AMAZON and Search For Products

  Background:
    Given User is on Amazon page "https://www.Amazon.co.uk"
  @smoke
  Scenario Outline: Search For Phones From Amazon 50-100

    When User Navigate to Main Category as <Department> and Subcategory as <Category> and <Subcategory>
    And  User Filters By Year as <Year> and Brand as <Brand> and Camera as <Camera> and Price as <MinPrice> and <MaxPrice>
    Then User should be able see the results as "Try checking your spelling or use more general terms"
    And  Close the browser
    Examples:
      | Department              | Category                |Subcategory   |Year|Brand  |Camera       |MinPrice|MaxPrice|
      | Electronics & Computers |  Phones & Accessories   | Smartphones  |2023|Samsung|20 MP & above|50      |100     |


  @smoke
  Scenario Outline: Search For Phones From Amazon Max Price 50-1000

    When User Navigate to Main Category as <Department> and Subcategory as <Category> and <Subcategory>
    And  User Filters By Year as <Year> and Brand as <Brand> and Camera as <Camera> and Price as <MinPrice> and <MaxPrice>
    Then User should be able see the results as <Brand> and Price as <MinPrice> and <MaxPrice>
    And  Close the browser
    Examples:
      | Department              | Category                |Subcategory   |Year|Brand  |Camera       |MinPrice|MaxPrice|
      | Electronics & Computers |  Phones & Accessories   | Smartphones  |2023|Samsung|20 MP & above|50      |1000     |