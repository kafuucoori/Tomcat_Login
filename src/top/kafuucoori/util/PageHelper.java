package top.kafuucoori.util;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/20 - 07 - 20 - 8:24
 * @Description: top.kafuucoori.util
 * @version: 1.0
 * 功能描述: 工具类，分页功能汇总
 * @param: pageNo 页码
 * @param: pageSize 页容量
 * @param: dataCount 数据总条数
 * @param: pageCount 总页数
 */
public class PageHelper {

    private int pageNo;
    private int pageSize;
    private int dataCount;
    private int pageCount;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    /**
     * 功能描述: 总页数设置
     *
     * @return: pageCount
     */
    public int getPageCount() {

        if (this.getDataCount() % this.getPageSize() == 0) {
            this.pageCount = this.dataCount / this.pageSize;
        } else {
            this.pageCount = this.dataCount / this.pageSize + 1;
        }
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
