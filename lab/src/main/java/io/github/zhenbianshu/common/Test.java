package io.github.zhenbianshu.common;

/**
 * @author xiepengfei 2019/1/31
 */
public class Test {
    private String aaa;
    private int bbb;
    private Long[] ccc;

    Test(String aaa, int bbb, Long[] ccc) {
        this.aaa = aaa;
        this.bbb = bbb;
        this.ccc = ccc;
    }


    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public int getBbb() {
        return bbb;
    }

    public void setBbb(int bbb) {
        this.bbb = bbb;
    }

    public Long[] getCcc() {
        return ccc;
    }

    public void setCcc(Long[] ccc) {
        this.ccc = ccc;
    }
}
