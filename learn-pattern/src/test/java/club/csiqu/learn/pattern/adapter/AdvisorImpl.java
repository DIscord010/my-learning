package club.csiqu.learn.pattern.adapter;

/**
 * @author Siqu Chen 2020/9/23
 * @since 1.0
 */
public class AdvisorImpl implements Advisor {

    private final Advice advice;

    public AdvisorImpl(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }
}