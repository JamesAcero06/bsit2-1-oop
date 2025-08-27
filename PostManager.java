import java.util.*;

public class PostManager {

    public int calculateEngagement(int... interactions) {
        if (interactions == null || interactions.length == 0) {
            return 0;
        }
        int total = 0;
        for (int i : interactions) {
            total += i;
        }
        return total;
    }

    public String getCategoryRating(int engagementScore) {
        if (engagementScore >= 1000) return "Viral";
        else if (engagementScore >= 500) return "Popular";
        else if (engagementScore >= 100) return "Good";
        else if (engagementScore >= 50) return "Low";
        else return "Poor";
    }

    public void displayPostStats(String postTitle, int engagementScore, String category) {
        System.out.println("Post: " + postTitle);
        System.out.println("Engagement Score: " + engagementScore);
        System.out.println("Category: " + category);

    }



    public ArrayList<String> manageHashtags(String[] hashtags) {
        ArrayList<String> uniqueHashtags = new ArrayList<>();
        if (hashtags != null) {
            for (String tag : hashtags) {
                if (!uniqueHashtags.contains(tag)) {
                    uniqueHashtags.add(tag);
                }
            }
        }
        return uniqueHashtags;
    }

    public LinkedList<String> findTrendingPosts(ArrayList<String> posts, HashMap<String, Integer> postEngagement) {
        LinkedList<String> trendingPosts = new LinkedList<>();
        if (posts != null && postEngagement != null) {
            for (String post : posts) {
                Integer score = postEngagement.get(post);
                if (score != null && score > 500) {
                    trendingPosts.add(post);
                }
            }
        }
        return trendingPosts;
    }

    public HashSet<String> getUniqueAuthors(String... authors) {
        HashSet<String> uniqueAuthors = new HashSet<>();
        if (authors != null) {
            for (String author : authors) {
                uniqueAuthors.add(author);
            }
        }
        return uniqueAuthors;
    }

    public static void main(String[] args) {
        PostManager manager = new PostManager();

        String postTitle = "Java Programming Tips";
        int engagementScore = manager.calculateEngagement(150, 75, 25);
        String category = manager.getCategoryRating(engagementScore);

        System.out.println("═══ Social Media Post Manager ═══");
        System.out.println();
        manager.displayPostStats(postTitle, engagementScore, category);

        String[] hashtags = {"#java", "#coding", "#programming", "#java", "#tips"};
        ArrayList<String> uniqueHashtags = manager.manageHashtags(hashtags);
        System.out.println("\nUnique Hashtags: " + uniqueHashtags);

        ArrayList<String> posts = new ArrayList<>(Arrays.asList("Advanced Java Tutorial", "Spring Boot Guide", "Beginner Python"));
        HashMap<String, Integer> postEngagement = new HashMap<>();
        postEngagement.put("Advanced Java Tutorial", 1200);
        postEngagement.put("Spring Boot Guide", 800);
        postEngagement.put("Beginner Python", 300);

        LinkedList<String> trendingPosts = manager.findTrendingPosts(posts, postEngagement);
        System.out.println("Trending Posts: " + trendingPosts);

        HashSet<String> uniqueAuthors = manager.getUniqueAuthors("Alice", "Bob", "Alice", "Charlie", "Bob");
        System.out.println("\nUnique Authors: " + uniqueAuthors);
    }
}
