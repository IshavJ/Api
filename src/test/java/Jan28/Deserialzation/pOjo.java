package Jan28.Deserialzation;

import java.util.List;

public class pOjo {
    private String page;
    private String per_page;
    private String total;
    private String total_pages;
    private List<pOjo_data> data;
    private pOjo_support support;

    public String getPage() {
        return page;
    }

    public String getPer_page() {
        return per_page;
    }

    public String getTotal() {
        return total;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public List<pOjo_data> getData() {
        return data;
    }

    public pOjo_support getSupport() {
        return support;
    }

    @Override
    public String toString() {
        return "pOjo{" +
                "page='" + page + '\'' +
                ", per_page='" + per_page + '\'' +
                ", total='" + total + '\'' +
                ", total_pages='" + total_pages + '\'' +
                ", data=" + data +
                ", support=" + support +
                '}';
    }
}