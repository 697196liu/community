package com.nowcoder.community.entity;

public class Page {
    //当前页码
    private Integer current=1;
    //显示上限
    private Integer limit=10;
    //数据总数（用于计算总页数）
    private Integer rows;
    //查询路径（用于复用分页链接）
    private String path;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        if(current>=1){
            this.current = current;
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if(limit>=1&&limit <=100){
            this.limit = limit;
        }
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        if(rows >=0){
            this.rows = rows;
        }

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     * @return
     */
    public int getOffset(){
        return (current -1)*limit;
    }
    /**
     * 获取总页数
     */
    public int getTotal(){
        if(rows%limit==0){
            return rows/limit;
        }
        return rows/limit+1;
    }


    /**
     * 起始页
     * @return
     */
    public int getFrom(){
        int from = current -2;
        return from<1?1:from;
    }

    public int getTo(){
        int to = current +2;
        int total = getTotal();
        return to>total ?total:to;
    }
}
