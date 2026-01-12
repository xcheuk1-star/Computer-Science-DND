import java.util.ArrayList;
import java.util.List;

/**
 * Represents a directory in the file system tree. A directory can contain other directories and
 * files as children.
 */
public class FolderNode extends FileSystemNode {

    private List<FileSystemNode> children;

    public FolderNode(String name, FolderNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }


    @Override
    public boolean isFolder() {
        return true;
    }

    /**
     * Returns a list view of the children contained directly inside this directory. Modifying the
     * returned list is not required to be supported.
     */
    public List<FileSystemNode> getChildren() {
        // TODO: return the list of child nodes (possibly a defensive copy)
        return children;
    }

    /**
     * Searches the children of this directory for a node whose name matches the input. Only direct
     * children are considered, not deeper descendants.
     */
    public FileSystemNode getChildByName(String childName) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getName().equals(childName)) {
                return children.get(i);
            }
        }
        System.out.println("Child not found");
        return null;
    }

    /**
     * Creates a new file directly inside this directory with the given name and size. If a child
     * with the same name already exists, no file is created and false is returned. Otherwise the
     * new file is added and true is returned.
     */
    public boolean addFile(String fileName, int size) {
        // TODO: implement uniqueness check and insertion of a new FileNode
        if (this.getChildByName(fileName) != null) {
            return false;
        }
        FileNode file = new FileNode(fileName, this, size);
        children.add(file);
        return true;
    }

    /**
     * Creates a new subdirectory directly inside this directory with the given name. If a child
     * with the same name already exists, no folder is created and false is returned. Otherwise the
     * new folder is added and true is returned.
     */
    public boolean addFolder(String folderName) {
        // TODO: implement uniqueness check and insertion of a new FolderNode
        if (this.getChildByName(folderName) != null) {
            return false;
        }
        FolderNode folder = new FolderNode(folderName, this);
        children.add(folder);
        return true;
    }

    /**
     * Searches this directory and all of its descendants for nodes whose name matches the input.
     * When a match is found, its full path can be printed by the caller using toString().
     */
    public boolean containsNameRecursive(String searchName) {
        // TODO: check this directory and all descendants for the given name
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).isFolder() == true) {
                FolderNode temp = (FolderNode) children.get(i);
                temp.containsNameRecursive(searchName);
            } else {
                if (children.get(i).getName().equals(searchName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void findHelper(String searchName) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getName().equals(searchName)) {
                System.out.println(children.get(i).toString());
            }
            if (children.get(i).isFolder() == true) {
                FolderNode temp = (FolderNode) children.get(i);
                temp.findHelper(searchName);
            }
        }
    }

    @Override
    public int getHeight() {
        // TODO: compute the maximum height among children; empty folders have value 0
        int max = 0;
        for (int i = 0; i < children.size(); i++) {
            int h = children.get(i).getHeight();
            if (h > max) {
                max = h;
            }
        }
        return 1 + max;
    }

    @Override
    public int getSize() {
        // TODO: sum the sizes of all files contained in this directory and its descendants
        int size = 0;
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).isFolder()) {
                size += children.get(i).getSize();
            } else {
                size += children.get(i).getSize();
            }
        }
        return size;
    }

    @Override
    public int getTotalNodeCount() {
        // TODO: count this directory plus all descendant files and folders
        int nodeCount = 1;
        for (int i = 0; i < children.size(); i++) {
            nodeCount += children.get(i).getTotalNodeCount();
        }
        return nodeCount;
    }
}


