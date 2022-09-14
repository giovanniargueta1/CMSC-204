public class DataSetGen<T>{
	private double sum;
	private Measurable maximum;
	private int count;


	public DataSetGen()
	{
		maximum = null; sum = 0;
		count= 0;
	}


	public void add(Measurable x)
	{
		sum = sum + x.getMeasure();
		if (count == 0 || maximum.getMeasure() < x.getMeasure())
			maximum=x;
		count++;
	}

	public double getAverage()
	{
		if (count == 0) return 0;
		else return sum / count;
	}

	@SuppressWarnings("unchecked")
	public T getMaximum()
	{
		return (T) maximum;
	}
}