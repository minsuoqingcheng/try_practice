package generics.result;

import java.util.List;

public class ResultListVO<T> {

    private int code;
    private List<T> data;

    public ResultListVO(int code, List<T> data) {
        this.code = code;
        this.data =  data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
