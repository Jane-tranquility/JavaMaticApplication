package recipes;
import java.util.List;

public class Recipe {
	private List<RecipeItem> recipeItemList;
	
	public Recipe(List<RecipeItem> recipeItemList) {
		if (recipeItemList==null) {
			throw new IllegalArgumentException("recipeItemList can not be null in Recipe construction.");
		}
		if (recipeItemList.isEmpty()) {
			throw new IllegalArgumentException("recipeItemList can not be empty in a Recipe construction.");
		}
		this.recipeItemList=recipeItemList;
	}
	
	public List<RecipeItem> getRecipeItemList(){
		return this.recipeItemList;
	}
}
