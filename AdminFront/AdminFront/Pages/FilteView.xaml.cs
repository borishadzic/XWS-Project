using AdminFront.DTOs;
using AdminFront.Requests;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace AdminFront.Pages
{
    /// <summary>
    /// Interaction logic for FilteView.xaml
    /// </summary>
    /// 


    public partial class FilteView : UserControl
    {

        FilterDTO filter = new FilterDTO();
        public FilteView()
        {
            InitializeComponent();

            filter = ClientRequests.getFilters();
            TypeList.ItemsSource = filter.types.Select(x=> x.type);
            CatagoryList.ItemsSource = filter.categories.Select(x=> x.category);
            ServicesList.ItemsSource = filter.services.Select(x=> x.name);
            DataContext = this;
        }


        public void addType(object sender, RoutedEventArgs arg)
        {
            
            if (NewType.Text == "")
            {
                MessageBox.Show("Cannot add blank name");
                return;
            }
            ClientRequests.addType(NewType.Text);
            filter = ClientRequests.getFilters();
            TypeList.ItemsSource=filter.types.Select(x=>x.type);
            
        }

        public void addService(object sender, RoutedEventArgs arg)
        {
            if (NewService.Text=="")
            {
                MessageBox.Show("Cannot add blank name");
                return;
            }
            ClientRequests.addService(NewService.Text);
            filter = ClientRequests.getFilters();
            ServicesList.ItemsSource = filter.services.Select(x => x.name);
        }
        public void addCatagory(object sender, RoutedEventArgs arg)
        {
            if (NewCatagory.Text == "")
            {
                MessageBox.Show("Cannot add blank name");
                return;
            }
            ClientRequests.addCatagory(NewCatagory.Text);
            filter = ClientRequests.getFilters();
            CatagoryList.ItemsSource = filter.categories.Select(x=> x.category);
        }


        public void modifyType(object sender, RoutedEventArgs arg)
        {
            if (ModifyType.Text == "")
            {
                MessageBox.Show("Cannot add blank name");
                return;
            }
            ClientRequests.modifyType((String)TypeList.SelectedItem, ModifyType.Text);
            filter = ClientRequests.getFilters();
            TypeList.ItemsSource = filter.types.Select(x => x.type);
        }

        public void modifyService(object sender, RoutedEventArgs arg)
        {
            if (ModifyService.Text == "")
            {
                MessageBox.Show("Cannot add blank name");
                return;
            }
            ClientRequests.modifyService((String)ServicesList.SelectedItem, ModifyService.Text);
            filter = ClientRequests.getFilters();
            ServicesList.ItemsSource = filter.services.Select(x => x.name);
        }

        public void modifyCategory(object sender, RoutedEventArgs arg)
        {
            if (ModifyCategory.Text == "")
            {
                MessageBox.Show("Cannot add blank name");
                return;
            }
            ClientRequests.modifyCategory((String)CatagoryList.SelectedItem, ModifyCategory.Text);
            filter = ClientRequests.getFilters();
            CatagoryList.ItemsSource = filter.categories.Select(x => x.category);
        }
    }
}
