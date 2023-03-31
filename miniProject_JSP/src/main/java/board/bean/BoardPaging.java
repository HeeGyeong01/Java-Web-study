package board.bean;

import lombok.Data;

@Data //setter/getter, public 기본 생성자, toString 만듦.
public class BoardPaging {
    private int currentPage;
    private int pageBlock; //[이전][1][2][3][다음]
    private int pageSize; //한 페이지 당 5개씩
    private int totalA; //총글수
    private StringBuffer pagingHTML;

    public StringBuffer makePagingHTML(){
        pagingHTML = new StringBuffer();

        int totalP = (totalA + pageSize)/ pageSize;//총 페이지 수;

        int startPage = (currentPage-1)/pageBlock *pageBlock +1;
        int endPage = startPage + pageBlock -1;

        if(endPage>totalP)
            endPage = totalP;

        if(startPage != 1)
            pagingHTML.append("<span id='paging' onclick='boardPaging(" + (startPage-1)+")'>이전</span>");

        for(int i=startPage; i<=endPage; i++){
            if(i == currentPage)
                pagingHTML.append("<span id='currentPaging' onclick='boardPaging("+ i +")' >" + i + "</span>");
            else
                pagingHTML.append("<span id='paging' onclick='boardPaging(" + i +")' >" + i + "</span>");
        }

        if(endPage < totalP) pagingHTML.append("<span id='paging' onclick='boardPaging(" + (endPage+1)+")'>[다음]</span>");

        return pagingHTML;
    }


}
