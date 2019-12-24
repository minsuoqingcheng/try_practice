package code_generate;

import java.util.Map;

public class ClassTemplate {

    private String className;
    private Map<String, Class<?>> key2type;

    public ClassTemplate() {
    }

    public ClassTemplate(String className, Map<String, Class<?>> key2Type) {
        this.className = className;
        this.key2type = key2Type;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Map<String, Class<?>> getKey2type() {
        return key2type;
    }

    public void setKey2type(Map<String, Class<?>> key2type) {
        this.key2type = key2type;
    }
}
