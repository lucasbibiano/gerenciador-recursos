package rewriter;

public class ExampleConfigurationProvider extends HttpConfigurationProvider
{
   @Override
   public int priority()
   {
     return 10;
   }

   @Override
   public Configuration getConfiguration(final ServletContext context)
   {
     return ConfigurationBuilder.begin()
       .addRule()
         .when(Direction.isInbound().and(Path.matches("/some/{page}/")))
         .perform(Forward.to("/new-{page}/"));
    }
}