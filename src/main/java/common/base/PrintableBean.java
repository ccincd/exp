package common.base;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * PrintableBean
 *
 * @author chi.chen
 * @date 16-3-17
 * @time 下午6:38
 */
public abstract class PrintableBean {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
