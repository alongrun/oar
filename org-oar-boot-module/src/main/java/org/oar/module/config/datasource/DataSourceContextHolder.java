package fastfish.mini.sns.bootmodules.config.datasource;

@SuppressWarnings("AlibabaConstantFieldShouldBeUpperCase")
public class DataSourceContextHolder {
    public static final String DEFAULT_DS = "entplatform";

    private static final ThreadLocal<String> CONTEXT_HOLDER = new InheritableThreadLocal<>();

    /**
     *  设置数据源
     * @param db
     */
    public static void setDataSource(String db){
        System.out.println("DataSourceContextHolder:"+db);
        CONTEXT_HOLDER.set(db);
    }

    /**
     * 取得当前数据源
     * @return
     */
    public static String getDataSource(){
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clear(){
        CONTEXT_HOLDER.remove();
    }
}
