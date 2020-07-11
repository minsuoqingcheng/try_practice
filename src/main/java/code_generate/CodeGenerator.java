package code_generate;

import com.sun.codemodel.internal.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CodeGenerator {

    private static final String PACKAGE_NAME = "code_generate";

    private static final String FOLDER_NAME = "/src/main/java/";

    public static void main(String[] args) throws IOException {
        ClassTemplate classTemplate = new ClassTemplate();
        classTemplate.setClassName("GenerateClass");
        Map<String, Class<?>> key2type = new HashMap<>();
        key2type.put("test1", String.class);
        classTemplate.setKey2type(key2type);
        parseClassTemplate(classTemplate);
    }


    private static void parseClassTemplate(ClassTemplate classTemplate) throws IOException {
        String basePath = System.getProperty("user.dir");
        String path = basePath + FOLDER_NAME;
        JCodeModel codeModel = new JCodeModel();
        JPackage jPackage = codeModel._package(PACKAGE_NAME);

        Map<String, Class<?>> key2type = classTemplate.getKey2type();
        try {
            JDefinedClass definedClass = jPackage._class(classTemplate.getClassName());
            for (Map.Entry<String, Class<?>> entry : key2type.entrySet()) {
                definedClass.field(JMod.PRIVATE, entry.getValue(), entry.getKey());
            }
            //生成 getter and setter
            generateGetterAndSetter(codeModel, definedClass);
            //构造 默认构造函数
            definedClass.constructor(JMod.PUBLIC);
            //构造全参的构造函数
            generateAllArgsConstructor(definedClass);
            codeModel.build(new File(path));
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }
    }


    private static void generateAllArgsConstructor(JDefinedClass definedClass) {
        Map<String, JFieldVar> fields = definedClass.fields();
        JMethod constructor = definedClass.constructor(JMod.PUBLIC);
        for (Map.Entry<String, JFieldVar> field : fields.entrySet()) {
            constructor.param(field.getValue().type(), field.getKey());
        }
    }


    private static void generateGetterAndSetter(JCodeModel codeModel, JDefinedClass definedClass) {
        Map<String, JFieldVar> fields = definedClass.fields();
        for (Map.Entry<String, JFieldVar> field : fields.entrySet()) {
            addGetterMethod(definedClass, field.getValue(), field.getKey(), field.getValue().type());
            addSetterMethod(codeModel, definedClass, field.getKey(), field.getValue().type());
        }
    }


    private static void addGetterMethod(JDefinedClass definedClass, JFieldVar fieldVar,  String key, JType keyType) {
        JMethod getter = definedClass.method(JMod.PUBLIC, keyType, "get" + firstToUpper(key));
        getter.body()._return(fieldVar);
    }

    private static void addSetterMethod(JCodeModel codeModel, JDefinedClass definedClass, String key, JType keyType) {
        JMethod setter = definedClass.method(JMod.PUBLIC, codeModel.VOID, "set" + firstToUpper(key));
        setter.param(keyType, key);
        setter.body().assign(JExpr._this().ref(key), JExpr.ref(key));
    }


    private static String firstToUpper(String key) {
        char first = key.charAt(0);
        if (first >= 'a' && first <= 'z') {
            first = (char) (first - ('a' - 'A'));
        }
        return first + key.substring(1);
    }

}
