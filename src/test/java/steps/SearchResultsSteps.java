package steps;

import pages.SearchResultPage;

public class SearchResultsSteps {
    private SearchResultPage searchResultPage = new SearchResultPage();

    public SearchResultsSteps verifyThatTopResultContainsCorrectText(String text) {
        searchResultPage.assertThatTopResultContainsText(text);
        return this;
    }
    public SearchResultsSteps verifyThatTopResultContainsProperAttributeText(String text) {

        searchResultPage.assertThatTopResultContainsPropertyAttributeText(text);
        return this;

}}