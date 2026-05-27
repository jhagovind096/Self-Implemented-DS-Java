
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

typedef struct trieNode
{
   char data;
   int  wEnd;
   struct trieNode *str[26];
}TrieNode;

TrieNode *createNode(char ch)
{
   TrieNode *node = (TrieNode* )malloc(sizeof(TrieNode));
   if(node == NULL)
   {
      printf("Memory Alloc Failed");
      return NULL;
   }
   node->data = ch;
   node->wEnd = 0;

   for (int i=0; i<26;i++)
     node->str[i] = NULL;

   return node;

}
bool search(char word[], TrieNode *root)
{
   if(word[0]=='\0')
      return false;
   TrieNode *p = root;
   int len = strlen(word);
   for (int i = 0 ;i< len;i++)
   {
      int idx = word[i]- 'a';
      if(p->str[idx] == NULL)
        return false;
      else
        p = p->str[idx];
   }

   return (p->wEnd > 0) ? true: false;


}

bool trieInsert(char word[], TrieNode *root)
{
   if(root == NULL)
      return NULL;

   int len = strlen(word);
   TrieNode *p = root;


   for(int i = 0;i< len;i++)
   {
      char c = word[i];
      if(p->str[c-'a'] == NULL){
      TrieNode *node = createNode(c);
      if(node != NULL)
      {
         p->str[c-'a'] = node;

         p = p->str[c-'a'];
      }
      else{
         return false;}
      }
      else
      {
         p=p->str[c-'a'];
      }
   }
   p->wEnd = p->wEnd + 1;
   return true;

}

bool delete(char word[], TrieNode *root)
{
   if (root == NULL)
   {
      return false;
   }
   TrieNode *p = root;
   int len = strlen(word);
   for(int i=0;i<len;i++)
   {
      int idx = word[i] - 'a';
      if(p->str[idx]!=NULL)
      {
         p=p->str[idx];
      }
      else
         return false;
   }

   if(p->wEnd > 0)
   {
      p->wEnd=0;
      return true;
   }
   else
      return false;
}

void freeTrie(TrieNode *node)
{
   if(node == NULL)
      return;

   for(int i = 0;i< 26 ;i++)
   {
      if(node->str[i]!=NULL)
      {
         freeTrie(node->str[i]);
      }
   }
   free(node);
}
int main()
{

   //insert into trie
   char str1[] = "hello";
   char str2[] = "how";
   char str3[] = "you";

   TrieNode *root = createNode('\0');

   if(root == NULL)
   {
      printf("root Node creation failed. Exiting ... ");
      return 0;
   }

   trieInsert(str1, root)?printf("String %s inserted:\n", str1):printf("Insertion Error for string %s", str1);
   trieInsert(str2, root)?printf("String %s inserted:\n", str2):printf("Insertion Error for string %s", str2);
   trieInsert(str3, root)?printf("String %s inserted:\n", str3):printf("Insertion Error for string %s", str3);


   printf("String ' %s ' present : %d \n",str2, search(str2, root));

   delete(str3,root)?printf("deletion succesful\n"):printf("Deletion failed\n");

   printf("String ' %s ' present : %d \n",str3, search(str3, root));
   freeTrie(root);
   return 1;
}
