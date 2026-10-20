package Dungeons.Character;

public class Quest {
    private String title;
    private String description;
    private boolean completed;

    public Quest(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }

    public void completeQuest() {
        this.completed = true;
        System.out.println("Quest Completed: " + title);
    }

    @Override
    public String toString() {
        return title + " - " + description + (completed ? " [COMPLETED]" : " [ACTIVE]");
    }
}