package personal.nutrisport.fatsecret.utils.response;

import java.util.List;

public class ResponseSuccess<T> {
    private final int
            pageNumber,
            maxResults,
            totalResults;
    private final List<T> resultList;

    public ResponseSuccess(int pageNumber, int maxResults, int totalResults, List<T> resultList) {
        this.pageNumber = pageNumber;
        this.maxResults = maxResults;
        this.totalResults = totalResults;
        this.resultList = resultList;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<T> getResultList() {
        return resultList;
    }

    @Override
    public String toString() {
        return "ResponseSuccess{" +
                "pageNumber=" + pageNumber +
                ", maxResults=" + maxResults +
                ", totalResults=" + totalResults +
                ", resultList=" + resultList +
                '}';
    }
}
